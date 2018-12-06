package com.example.spring.boot2.commons.repository;

import com.example.spring.boot2.commons.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuweijun
 * @since 2018-12-06
 */
public class PersonRepository {

    private final Map<Integer, Person> people = new HashMap<>();

    public PersonRepository() {
        this.people.put(1, new Person("John Doe", 42));
        this.people.put(2, new Person("Jane Doe", 36));
    }

    public Mono<Person> getPerson(int id) {
        return Mono.justOrEmpty(this.people.get(id));
    }

    public Flux<Person> allPeople() {
        return Flux.fromIterable(this.people.values());
    }

    public Mono<Void> savePerson(Mono<Person> personMono) {
        return personMono.doOnNext(person -> {
            int id = people.size() + 1;
            people.put(id, person);
            System.out.format("Saved %s with id %d%n", person, id);
        }).thenEmpty(Mono.empty());
    }

}
