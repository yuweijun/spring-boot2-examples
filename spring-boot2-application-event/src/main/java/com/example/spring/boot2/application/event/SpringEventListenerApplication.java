package com.example.spring.boot2.application.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("============ CommandLineRunner =================================================================");
    }

}


