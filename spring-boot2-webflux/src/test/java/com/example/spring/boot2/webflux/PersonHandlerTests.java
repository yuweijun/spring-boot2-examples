package com.example.spring.boot2.webflux;

import com.example.spring.boot2.SpringBoot2WebFluxApplication;
import com.example.spring.boot2.commons.model.Person;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @author yuweijun
 * @since 2018-12-06
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringBoot2WebFluxApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonHandlerTests {

    @Autowired
    private WebTestClient testClient;

    @Test
    public void createPerson() throws Exception {
        Person jack = new Person("Jack Doe", 16);

        this.testClient.post()
                .uri("/person/")
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody(jack)
                .exchange()
                .expectStatus().isOk();

    }

    @Test
    public void getPerson() throws Exception {
        this.testClient.get()
                .uri("/person/1")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Person.class).hasSize(1).returnResult();
    }

    @Test
    public void getPersonNotFound() throws Exception {
        this.testClient.get()
                .uri("/person/42")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    public void listPeople() throws Exception {
        this.testClient.get()
                .uri("/person/")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Person.class).hasSize(3).returnResult();
    }


}
