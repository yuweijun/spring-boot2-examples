package com.example.spring.boot2.docker.events.repository;

import com.example.spring.boot2.docker.events.model.DockerEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

/**
 * @author yuweijun
 * @since 2018-12-17
 */
public interface DockerEventMongoRepository extends ReactiveMongoRepository<DockerEvent, String> {

    @Tailable
    Flux<DockerEvent> findBy();

    @Tailable
    Flux<DockerEvent> findByStatus(String status);

    @Tailable
    Flux<DockerEvent> findByTypeAndFrom(String type, String from);

}
