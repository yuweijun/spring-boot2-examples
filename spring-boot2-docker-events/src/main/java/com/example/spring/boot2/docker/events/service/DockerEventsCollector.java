package com.example.spring.boot2.docker.events.service;

import com.example.spring.boot2.docker.events.model.DockerEvent;
import com.example.spring.boot2.docker.events.repository.DockerEventMongoRepository;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Event;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.EventsResultCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Objects;
import java.util.UUID;

/**
 * http://blog.51cto.com/liukang/2092881
 *
 * <pre>
 * 1. 这里使用的是MongoTemplate，Spring 4.3 之后，如果有构造方法，Spring会自动注入，不需要@Autowired注解了。
 * 2. 每次启动应用针对DockerEvent创建“capped”的collection，方便测试，如果提前手动创建好的话可以不加这两句。
 *    如果在//1处使用的是响应式的ReactiveMongoTemplate，因为是异步的，所以要用then()或thenMany()将后续的所有操作连接起来，
 *    如mongo.dropCollection(...).then(mongoTemplate.createCollection(...))
 *    .thenMany(dockerEventMongoRepository.saveAll(collect()))，保证能先后依次执行。
 * 3. 监听docker事件的方法。
 * 4. 将返回的Event转换为我们定义的DockerEvent，其中DockerEvent.from字段是事件主体名称，比如容器名，可能有/，因此进行一个字符替换，
 *    否则在URL中会有问题。
 * 5. 打印个日志（可选）。
 * 6. 将收集的DockerEvent保存到MongoDB，用subscribe()触发执行。
 * </pre>
 *
 * @since 2018-12-17
 */
@Component
public class DockerEventsCollector implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DockerEventsCollector.class);

    private DockerEventMongoRepository dockerEventMongoRepository;

    private MongoTemplate mongoTemplate;    // 1

    public DockerEventsCollector(DockerEventMongoRepository dockerEventMongoRepository,
                                 MongoTemplate mongoTemplate) {  // 1
        this.dockerEventMongoRepository = dockerEventMongoRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) {
        // 当capped 的 Collection中一条数据都没有的时候，@Tailable的API也会立刻返回
        mongoTemplate.dropCollection(DockerEvent.class);    // 2
        mongoTemplate.createCollection(DockerEvent.class,
                CollectionOptions.empty().maxDocuments(200).size(100000).capped()); // 2

        LOGGER.info("start docker flux event listener");
        dockerEventMongoRepository.saveAll(collect()).subscribe();  // 6
    }

    private Flux<DockerEvent> collect() {   // 3
        DockerClient docker = DockerClientBuilder.getInstance().build();

        return Flux.create((FluxSink<Event> sink) -> {
            EventsResultCallback callback = new EventsResultCallback() {
                @Override
                public void onNext(Event event) {
                    sink.next(event);
                }
            };

            docker.eventsCmd().exec(callback);
        }).map(this::trans)   // 4
                .doOnNext(event -> LOGGER.info(event.toString())); // 5
    }

    private DockerEvent trans(Event event) {    // 4
        DockerEvent dockerEvent = new DockerEvent();
        dockerEvent.setAction(event.getAction());
        dockerEvent.setActorId(Objects.requireNonNull(event.getActor()).getId());
        dockerEvent.setFrom(event.getFrom() == null ? null : event.getFrom().replace("//", "_"));
        dockerEvent.setId(UUID.randomUUID().toString());
        dockerEvent.setNode(event.getNode());
        dockerEvent.setStatus(event.getStatus());
        dockerEvent.setTime(event.getTime());
        dockerEvent.setTimeNano(event.getTimeNano());
        dockerEvent.setType(event.getType());
        return dockerEvent;
    }

}
