package com.example.spring.boot2.webflux.client;


import com.example.spring.boot2.commons.model.Person;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeFunctions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

/**
 * https://github.com/poutsma/web-function-sample
 */
public class PersonClient {

    private ExchangeFunction exchange = ExchangeFunctions.create(new ReactorClientHttpConnector());

    public static void main(String[] args) throws Exception {
        PersonClient client = new PersonClient();
        client.printAllPeople();
        client.createPerson();
    }

    public void printAllPeople() {
        URI uri = URI.create("http://localhost:8080/person");
        ClientRequest request = ClientRequest.create(HttpMethod.GET, uri).build();

        Flux<Person> people = exchange.exchange(request)
                .flatMapMany(response -> response.bodyToFlux(Person.class));

        Mono<List<Person>> peopleList = people.collectList();
        System.out.println(peopleList.block());
        System.out.println("-------------------------------");
    }

    public void createPerson() {
        URI uri = URI.create("http://localhost:8080/person/");
        Person jack = new Person("Jack Doe", 16);

        ClientRequest request = ClientRequest.create(HttpMethod.POST, uri)
                .body(BodyInserters.fromObject(jack)).build();

        Mono<ClientResponse> response = exchange.exchange(request);

        System.out.println(response.block().statusCode());
        System.out.println("-------------------------------");
    }

}
