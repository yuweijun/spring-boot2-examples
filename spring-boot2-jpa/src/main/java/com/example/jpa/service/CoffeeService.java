package com.example.jpa.service;

import com.example.jpa.model.Coffee;

import java.util.List;

/**
 * @author Weijun Yu
 * @since 2019-09-27.
 */
public interface CoffeeService {

  Coffee findByName(String name);

  List<Coffee> example(String name);

  List<Coffee> findBySQL(String name);
}
