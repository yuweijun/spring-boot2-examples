package com.example.jndi.database.controller;

import com.example.jndi.database.model.Country;
import com.example.jndi.database.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NamingException;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private CountryRepository countryRepository;

    private JndiTemplate jndiTemplate = new JndiTemplate();

    @GetMapping("/")
    public List<Country> home() {
        return countryRepository.findAll();
    }

    @GetMapping("/jndi")
    public String jndi() throws NamingException {
        String value = (String) jndiTemplate.lookup("java:/comp/env/test/jndi");
        return value;
    }

}
