package com.example.spring.boot2;

import com.example.spring.boot2.webflux.EmployeeWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2WebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2WebFluxApplication.class, args);

        EmployeeWebClient employeeWebClient = new EmployeeWebClient();
        employeeWebClient.consume();
    }
}
