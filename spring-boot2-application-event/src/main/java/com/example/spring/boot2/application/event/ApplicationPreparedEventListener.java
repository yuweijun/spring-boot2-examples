package com.example.spring.boot2.application.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author yuweijun
 * @since 2018-12-07
 */
public class ApplicationPreparedEventListener  implements ApplicationListener<ApplicationPreparedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationPreparedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        LOGGER.info("============ ApplicationPreparedEvent ==========================================================");
    }

}
