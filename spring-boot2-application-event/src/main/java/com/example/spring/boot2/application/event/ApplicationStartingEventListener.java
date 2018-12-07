package com.example.spring.boot2.application.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author yuweijun
 * @since 2018-12-07
 */
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartingEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        LOGGER.info("============ ApplicationStartingEvent ==========================================================");
        System.out.println("=========================================================================================");
        System.out.println("============ ApplicationStartingEvent ===================================================");
        System.out.println("=========================================================================================");
    }

}
