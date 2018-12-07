package com.example.spring.boot2.application.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

/**
 * An ApplicationStartedEvent is sent after the context has been refreshed but before any application and command-line
 * runners have been called.An ApplicationReadyEvent is sent after any application and command-line runners have been
 * called. It indicates that the application is ready to service requests
 *
 * @author yuweijun
 * @since 2018-12-07
 */
@SpringBootApplication
public class SpringEventListenerApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringEventListenerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringEventListenerApplication.class, args);
    }

    @Autowired
    private Environment environment;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("============ CommandLineRunner =================================================================");
        
        String id = environment.getProperty("com.example.foo.id");
        LOGGER.info("foo.id = {}", id);

        Binder binder = Binder.get(environment);
        FooProperties foo = binder.bind("com.example.foo", Bindable.of(FooProperties.class)).get();
        LOGGER.info("foo.name = {}", foo.getName());
    }

}


