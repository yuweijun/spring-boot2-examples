package com.example.spring.boot2.docker.events.controller;

import com.example.spring.boot2.docker.events.model.DockerEvent;
import com.example.spring.boot2.docker.events.repository.DockerEventMongoRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * http://blog.51cto.com/liukang/2092881
 *
 * 可以看到，右侧的浏览器的小图标一直在旋转，表示持续接收推送中，当在终端中进行docker操作的时候，所产生的事件就立刻出现在浏览器中了。
 *
 * 如果请求/docker/events/oom将只推送OOM事件，
 *
 * 如果请求/docker/events/container/progrium_stress将只推送来自容器progrium/stress的事件。
 *
 * 再次提醒，当capped 的 Collection中一条数据都没有的时候，@Tailable的API也会立刻返回，
 *
 * 所以需要等到数据库中有至少一条数据之后（比如先执行以下pull），再在浏览器中请求docker/eventsAPI。
 *
 * @since 2018-12-17
 */
@RestController
@RequestMapping(value = "/docker/events", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)    // 1
public class DockerEventController {

    private DockerEventMongoRepository dockerEventMongoRepository;

    public DockerEventController(DockerEventMongoRepository dockerEventMongoRepository) {
        this.dockerEventMongoRepository = dockerEventMongoRepository;
    }

    @GetMapping
    public Flux<DockerEvent> dockerEventStream() {  // 2
        return dockerEventMongoRepository.findBy();
    }

    @GetMapping("/{type}/{from}")
    public Flux<DockerEvent> dockerEventStream(@PathVariable("type") String type,
                                               @PathVariable("from") String from) {  // 3
        return dockerEventMongoRepository.findByTypeAndFrom(type, from);
    }

    @GetMapping("/{status}")
    public Flux<DockerEvent> dockerEventStream(@PathVariable String status) {   // 4
        return dockerEventMongoRepository.findByStatus(status);
    }

}
