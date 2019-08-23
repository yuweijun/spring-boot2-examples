package com.example.jpa;

import com.example.jpa.model.Coffee;
import com.example.jpa.model.Order;
import com.example.jpa.model.User;
import com.example.jpa.repository.CoffeeRepository;
import com.example.jpa.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Date;

@Slf4j
@EnableJpaRepositories
@SpringBootApplication
public class SpringBoot2JpaApplication implements ApplicationRunner {

  public static void main(String[] args) {
    SpringApplication.run(SpringBoot2JpaApplication.class, args);
  }

  @Autowired
  private CoffeeRepository coffeeRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Override
  public void run(ApplicationArguments args) {
    initOrders();
  }

  private void initOrders() {
    Coffee espresso = Coffee.builder().name("espresso")
        .price(20L)
        .build();
    coffeeRepository.save(espresso);
    log.info("Coffee: {}", espresso);

    Coffee latte = Coffee.builder().name("latte")
        .price(30L)
        .build();
    coffeeRepository.save(latte);
    log.info("Coffee: {}", latte);

    User user = User.builder().id(1).name("name1").nickName("nickName1").build();
    Order order = Order.builder()
        .user(user)
        .description("desc")
        .items(Arrays.asList(espresso, latte))
        .createTime(new Date())
        .build();
    orderRepository.save(order);
    log.info("Order: {}", order);

    order = Order.builder()
        .user(user)
        .createTime(new Date())
        .items(Arrays.asList(espresso, latte))
        .build();
    orderRepository.save(order);
    log.info("Order: {}", order);
  }
}
