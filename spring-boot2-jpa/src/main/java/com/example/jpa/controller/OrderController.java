package com.example.jpa.controller;

import com.example.jpa.model.Order;
import com.example.jpa.model.User;
import com.example.jpa.repository.OrderRepository;
import com.example.jpa.service.OrderService;
import com.example.jpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Optional;

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
  private OrderRepository orderRepository;

  @Autowired
  private UserService userService;

  @Autowired
  private OrderService orderService;

  @Autowired
  private EntityManager entityManager;

  @GetMapping("/")
  public Iterable<Order> list() {
    Iterable<Order> all = orderRepository.findAll();
    Order order = all.iterator().next();
    User user = order.getUser();

    saveClass(user);

    return all;
  }

  @GetMapping("/{id}")
  public Order get(@PathVariable int id) {
    // test session flush and update in JTA
    userService.update();

    Optional<Order> optionalOrder = orderRepository.findById(id);
    if (optionalOrder.isPresent()) {
      Order order = optionalOrder.get();
      // Order$HibernateProxy
      saveClass(order);

      return order;
    }

    return null;
  }

  private void saveClass(Order order) {
    try {
      ByteBuddyAgent.install();
      Class<? extends Order> orderClass = order.getClass();

      ClassFileLocator classFileLocator = ClassFileLocator
              .AgentBased
              .fromInstalledAgent(orderClass.getClassLoader());
      DynamicType.Unloaded<? extends Object> unloaded = new ByteBuddy()
              .redefine(orderClass, classFileLocator).make();
      Map<TypeDescription, File> saved = unloaded.saveIn(Files.createTempDirectory("proxy").toFile());
      saved.forEach((t, u) -> LOGGER.info(u.getAbsolutePath()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  private void saveClass(User user) {
    try {
      ByteBuddyAgent.install();
      Class<? extends User> userClass = user.getClass();

      ClassFileLocator classFileLocator = ClassFileLocator
          .AgentBased
          .fromInstalledAgent(userClass.getClassLoader());
      DynamicType.Unloaded<? extends Object> unloaded = new ByteBuddy()
          .redefine(userClass, classFileLocator).make();
      Map<TypeDescription, File> saved = unloaded.saveIn(Files.createTempDirectory("proxy").toFile());
      saved.forEach((t, u) -> LOGGER.info(u.getAbsolutePath()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @GetMapping("/add/{id}")
  public Order add(@PathVariable int id) {
    return orderService.findById(id);
  }

  @GetMapping("/add2/{id}")
  public Order add2(@PathVariable int id) {
    return orderService.findById2(id);
  }

}
