package com.example.spring.boot2.reactive.security;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@ComponentScan(basePackages = {"com.example.spring.boot2.reactive.security"})
@EnableWebFlux
public class SpringSecurity5Application {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(SpringSecurity5Application.class);
    }

}
