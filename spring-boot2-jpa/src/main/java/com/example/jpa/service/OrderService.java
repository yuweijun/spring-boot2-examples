package com.example.jpa.service;

import com.example.jpa.model.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Weijun Yu
 * @since 2019-09-27.
 */
public interface OrderService {
  List<Order> findAll();

  Order findById(int id);

  @Transactional
  Order addCoffee(int id);

  Order addCoffee2(int id);
}
