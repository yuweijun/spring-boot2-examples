package com.example.dit.controller;

import com.example.dit.model.Country;
import com.example.dit.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/")
    public List<Country> home() {
        return countryRepository.findAll();
    }

}
