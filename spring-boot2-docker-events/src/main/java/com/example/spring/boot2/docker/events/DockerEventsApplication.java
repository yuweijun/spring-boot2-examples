package com.example.spring.boot2.docker.events;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <pre>
 * 1. 启动测试用例，访问 http://localhost:8080/docker/events
 * 2. docker container restart mysql-server
 * 3. docker run -it -m 200M --memory-swap=200M progrium/stress --vm 1 --vm-bytes 300M
 * 4. refresh http://localhost:8080/docker/events
 * 5. docker run -it -m 200M --memory-swap=200M progrium/stress --vm 1 --vm-bytes 300M
 * 6. docker container restart mysql-server
 * </pre>
 *
 * progrium/stress是一个用于压力测试的容器，通过-m 200M指定为该容器的运行最多分配200M内存，
 *
 * 然后在压力测试的时候，通过--vm-bytes 300M使其运行时尝试分配300M的内存，此时会出现内存不足（OOM）的错误并导致容器被杀死（single 9）。
 *
 * @author yuweijun
 * @since 2018-12-17
 */
@SpringBootApplication
public class DockerEventsApplication {

    /**
     * <pre>
     * 1. 创建DockerClient。
     * 2. 自定义回调类。
     * 3. 当有docker事件产生时，会回调onNext，这时候通过FluxSink的next方法将Event对象发出。
     * 4. 开始对docker事件进行监听。
     * 5. 通过订阅的方式打印出来。
     * </pre>
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(DockerEventsApplication.class).run(args);

        // DockerClient docker = DockerClientBuilder.getInstance().build();    // 1
        // Flux.create((FluxSink<Event> sink) -> {
        //     EventsResultCallback callback = new EventsResultCallback() {    // 2
        //         @Override
        //         public void onNext(Event event) {   // 3
        //             sink.next(event);
        //         }
        //     };
        //     docker.eventsCmd().exec(callback);  // 4
        // }).subscribe(System.out::println); // 5
    }

}
