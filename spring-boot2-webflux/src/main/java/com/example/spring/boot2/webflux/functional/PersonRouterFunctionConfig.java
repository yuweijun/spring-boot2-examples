package com.example.spring.boot2.webflux.functional;

import com.example.spring.boot2.commons.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author yuweijun
 * @since 2018-12-06
 */
@Configuration
public class PersonRouterFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> routingFunction() {
        PersonRepository repository = new PersonRepository();
        PersonHandler handler = new PersonHandler(repository);

        return nest(path("/person"),
                nest(accept(APPLICATION_JSON),
                        route(GET("/{id}"), handler::getPerson)
                                .andRoute(method(HttpMethod.GET), handler::listPeople)
                ).andRoute(POST("/").and(contentType(APPLICATION_JSON)), handler::createPerson));
    }


}
