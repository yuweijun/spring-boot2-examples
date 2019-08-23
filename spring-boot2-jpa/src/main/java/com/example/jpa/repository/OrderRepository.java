package com.example.jpa.repository;


import com.example.jpa.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
