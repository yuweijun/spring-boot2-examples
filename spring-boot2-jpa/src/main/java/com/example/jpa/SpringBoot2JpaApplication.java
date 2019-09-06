package com.example.jpa;

import com.example.jpa.model.*;
import com.example.jpa.repository.CoffeeRepository;
import com.example.jpa.repository.OrderRepository;
import com.example.jpa.repository.UserRepository;
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

  @Autowired
  private UserRepository userRepository;

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

    User user = User.builder()
        .name("yu")
        .mobile("13800000831")
        .nickName("test")
        .experience(Experience.PROFESSIONAL)
        .address(new Address("street", "city"))
        .createTime(new Date())
        .updateTime(new Date())
        .build();
    userRepository.save(user);

    Order order1 = Order.builder()
        .user(user)
        .description("desc")
        .coffee(Arrays.asList(espresso))
        .createTime(new Date())
        .build();
    orderRepository.save(order1);
    log.info("Order: {}", order1);

    Order order2 = Order.builder()
        .user(user)
        .createTime(new Date())
        .coffee(Arrays.asList(espresso, latte))
        .build();
    orderRepository.save(order2);

    log.info("Order: {}", order2);
  }

}
