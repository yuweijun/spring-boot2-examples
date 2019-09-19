package com.example.jpa.service;

import com.example.jpa.model.Coffee;
import com.example.jpa.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 * @author yuweijun
 * @since 2019-08-24
 */
@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private EntityManager entityManager;

    public Coffee findByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Coffee> criteria = cb.createQuery(Coffee.class);
        Root<Coffee> i = criteria.from(Coffee.class);
        criteria.select(i)
                .where(cb.equal(i.get("name"), name))
                .orderBy(cb.desc(i.get("id")));

        TypedQuery<Coffee> typedQuery = entityManager.createQuery(criteria);
        return typedQuery.getSingleResult();
    }
}
