package com.example.jpa.controller;

import com.example.jpa.model.Coffee;
import com.example.jpa.repository.CoffeeRepository;
import com.example.jpa.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuweijun
 * @since 2019-08-23
 */
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping("/")
    public Iterable<Coffee> list() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Coffee get(@PathVariable int id) {
        return coffeeRepository.findById(id).get();
    }

    @GetMapping("/find/by/name")
    public Coffee findByName(String name) {
        return coffeeService.findByName(name);
    }

    @GetMapping("/find/by/example")
    public List<Coffee> example(String name) {
        return coffeeService.example(name);
    }

}
