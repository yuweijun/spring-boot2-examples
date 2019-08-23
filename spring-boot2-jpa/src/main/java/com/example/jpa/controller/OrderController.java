package com.example.jpa.controller;

import com.example.jpa.model.Order;
import com.example.jpa.repository.OrderRepository;
import com.example.jpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author yuweijun
 * @since 2019-08-23
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public Iterable<Order> list() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable int id) {
        userService.update();

        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        }

        return null;
    }

}
