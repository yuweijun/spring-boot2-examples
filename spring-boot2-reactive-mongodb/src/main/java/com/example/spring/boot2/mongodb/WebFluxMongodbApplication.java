package com.example.spring.boot2.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * @author yuweijun
 * @since 2018-12-07
 */
@SpringBootApplication
@EnableReactiveMongoRepositories
public class WebFluxMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxMongodbApplication.class, args);
    }

}
