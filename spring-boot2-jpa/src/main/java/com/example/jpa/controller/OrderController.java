package com.example.jpa.controller;

import com.example.jpa.model.Order;
import com.example.jpa.model.User;
import com.example.jpa.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.spring.boot2.commons.utils.ByteBuddyUtil.saveGeneratedClass;

/**
 * @author yuweijun
 * @since 2019-08-23
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

  @Autowired
  private OrderService orderService;

  @Autowired
  private EntityManager entityManager;

  @GetMapping("/")
  public Iterable<Order> list() {
    List<Order> all = orderService.findAll();
    Order order = all.get(0);

    User user = order.getUser();
    saveGeneratedClass(user.getClass());

    return all;
  }

  @GetMapping("/{id}")
  public Order get(@PathVariable int id) {
    Order reference = entityManager.getReference(Order.class, id);
    // Order$HibernateProxy
    saveGeneratedClass(reference.getClass());

    return orderService.findById(id);
  }

  @GetMapping("/add/{id}")
  public Order add(@PathVariable int id) {
    return orderService.addCoffee(id);
  }

  @GetMapping("/add2/{id}")
  public Order add2(@PathVariable int id) {
    return orderService.addCoffee2(id);
  }

}
