package com.example.spring.boot2.hello.world;

/**
 * @author yuweijun
 * @since 2018-12-05
 */
public class HelloWorld {

    private String name;

    public HelloWorld() {
    }

    public HelloWorld(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "name='" + name + '\'' +
                '}';
    }
}
