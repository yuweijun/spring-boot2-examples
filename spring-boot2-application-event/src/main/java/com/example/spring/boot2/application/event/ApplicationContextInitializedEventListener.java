package com.example.spring.boot2.application.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author yuweijun
 * @since 2018-12-07
 */
public class ApplicationContextInitializedEventListener implements ApplicationListener<ApplicationContextInitializedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextInitializedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent event) {
        LOGGER.info("============ ApplicationContextInitializedEvent ================================================");
    }

}
