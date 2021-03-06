package com.example.spring.boot2.reactive.actuator;

import com.example.spring.boot2.SpringBoot2WebFluxApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringBoot2WebFluxApplication.class)
public class ActuatorInfoIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenGetInfo_thenReturns200() throws IOException {
        final ResponseEntity<String> responseEntity = restTemplate.getForEntity("/actuator/info", String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void whenFeatures_thenReturns200() throws IOException {
        final ResponseEntity<String> responseEntity = restTemplate.getForEntity("/actuator/features", String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
