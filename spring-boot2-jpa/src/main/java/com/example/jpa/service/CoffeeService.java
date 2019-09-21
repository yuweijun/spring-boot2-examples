package com.example.jpa.service;

import com.example.jpa.model.Coffee;
import com.example.jpa.repository.CoffeeRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * @author yuweijun
 * @since 2019-08-24
 */
// @Service
// @Named("coffeeService")
@Named
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

    public List<Coffee> example(String name) {
        Coffee coffee = new Coffee();
        coffee.setName(name);
        Example example = Example.create(coffee);
        example.ignoreCase();
        example.enableLike(MatchMode.START);
        Session session = entityManager.unwrap(Session.class);
        @SuppressWarnings("deprecated")
        Criteria criteria = session.createCriteria(Coffee.class).add(example);
        return criteria.list();
    }

    public List<Coffee> findBySQL(String name) {
        Query nativeQuery = entityManager.createNativeQuery("select * from t_coffee where name like ?", Coffee.class);
        // JPA parameter begin from 1 just like as JDBC statement, but Hibernate begin from 0
        nativeQuery.setParameter(1, name + "%");
        return nativeQuery.getResultList();
    }
}
