package com.example.jpa.service;

import com.example.jpa.model.Coffee;
import com.example.jpa.model.Order;
import com.example.jpa.repository.CoffeeRepository;
import com.example.jpa.repository.OrderRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * @author yuweijun
 * @since 2019-08-24
 */
@Service("orderService2")
public class OrderService2Impl implements OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CoffeeRepository coffeeRepository;

  @Override
  public List<Order> findAll() {
    return Lists.newArrayList(orderRepository.findAll());
  }

  @Override
  public Order findById(int id) {
    Optional<Order> optionalOrder = orderRepository.findById(id);
    if (optionalOrder.isPresent()) {
      return optionalOrder.get();
    }

    return null;
  }

  @Override
  @Transactional
  public Order addCoffee(int id) {
    Coffee america = Coffee.builder().name("America")
        .price(20L)
        .build();
    coffeeRepository.save(america);

    Optional<Order> optionalOrder = orderRepository.findById(id);
    if (optionalOrder.isPresent()) {
      Order order = optionalOrder.get();
      // List<Coffee> 会删除原来的元素, 正确实现 Order#hashCode/equals 的 Set<Coffee> 则不会
      //     delete
      //     from
      //         t_order_coffee
      //     where
      //         order_id=?
      // 然后再关系表 t_order_coffee 增加 n 条数据
      //     insert
      //     into
      //         t_order_coffee
      //         (order_id, coffee_id)
      //     values
      //         (?, ?)
      order.getCoffee().add(america);
      return order;
    }

    return null;
  }

  @Override
  public Order addCoffee2(int id) {
    Coffee america = Coffee.builder().name("America")
        .price(20L)
        .build();
    coffeeRepository.save(america);

    Optional<Order> optionalOrder = orderRepository.findById(id);
    if (optionalOrder.isPresent()) {
      Order order = optionalOrder.get();
      // 不会删除原来的元素 delete from
      // 不会增加关系表数据
      order.getCoffee().add(america);
      return order;
    }

    return null;
  }

}
