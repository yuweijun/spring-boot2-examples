package com.example.spring.boot2.hello.world;


import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.time.Duration;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class FunctionalWebApplication {

    static RouterFunction getRouter() {
        HandlerFunction<ServerResponse> hello = request -> ok().body(fromObject("HelloWorld"));

        return route(GET("/"), hello)
                .andRoute(GET("/json"),
                        req -> ok().contentType(APPLICATION_JSON).body(fromObject(new HelloWorld("hello world")))
                );
    }

    /**
     * java.lang.UnsatisfiedLinkError: no netty_transport_native_epoll_x86_64 in java.library.path:
     * [/usr/java/packages/lib, /usr/lib64, /lib64, /lib, /usr/lib]
     *
     * 启动 DEBUG 提示信息如上，可忽略
     */
    public static void main(String[] args) throws InterruptedException {
        RouterFunction router = getRouter();

        HttpHandler httpHandler = RouterFunctions.toHttpHandler(router);
        ReactorHttpHandlerAdapter handlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);

        HttpServer httpServer = HttpServer.create()
                .host("localhost")
                .port(8080);

        // 启动方式一测试使用
        // httpServer.handle(handlerAdapter).bind().block();
        // Thread.currentThread().join();

        // 启动方式二服务使用
        NettyWebServer webServer = new NettyWebServer(httpServer, handlerAdapter, Duration.ofSeconds(1L));
        webServer.start();
    }

}
