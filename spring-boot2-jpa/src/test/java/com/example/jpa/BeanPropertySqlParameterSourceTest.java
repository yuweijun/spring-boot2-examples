package com.example.jpa;

import com.example.jpa.model.Order;
import com.example.jpa.model.User;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import java.util.Arrays;
import java.util.Date;

public class BeanPropertySqlParameterSourceTest {

  @Test
  public void test1() {
    User user = User.builder().id(1).name("name1").nickName("nickName1").build();
    Order order = Order.builder().createTime(new Date()).updateTime(new Date())
        .description("desc").id(1).user(user).build();

    BeanPropertySqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(order);
    String[] parameterNames = sqlParameterSource.getParameterNames();
    Arrays.stream(parameterNames).forEach(s -> {
      System.out.printf("%10s%n", s);
    });

    Object id = sqlParameterSource.getValue("id");
    System.out.println(id);
    Object u = sqlParameterSource.getValue("user");
    System.out.println(u);
    Object name = sqlParameterSource.getValue("user.name");
    System.out.println(name);
  }

}
