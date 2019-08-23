package com.example.jpa;

import com.example.jpa.model.Order;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * @author Weijun Yu
 * @since 2019-08-23.
 */
public class BeanPropertyRowMapperTest {

  @Test
  public void test1() {
    BeanPropertyRowMapper<Order> rowMapper = new BeanPropertyRowMapper<>(Order.class);
    Class<Order> mappedClass = rowMapper.getMappedClass();
    System.out.println(mappedClass);
  }

}
