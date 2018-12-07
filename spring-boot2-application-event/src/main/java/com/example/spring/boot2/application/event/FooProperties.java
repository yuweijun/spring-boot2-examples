package com.example.spring.boot2.application.event;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yuweijun
 * @since 2018-12-07
 */
@ConfigurationProperties(prefix = "com.example.foo")
public class FooProperties {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
