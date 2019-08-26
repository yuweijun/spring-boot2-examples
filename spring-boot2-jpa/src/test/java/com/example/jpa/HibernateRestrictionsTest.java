package com.example.jpa;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.junit.Test;

/**
 * @author Weijun Yu
 * @since 2019-08-26.
 */
public class HibernateRestrictionsTest {

  @Test
  public void test1() {
    Criterion age = Restrictions.between("age", new Integer(20), new Integer(30));
    System.out.println(age);
  }
  
  @Test
  public void test2() {
    SimpleExpression age = Restrictions.ge("age", 1);
    System.out.println(age);
  }

  @Test
  public void test3() {
    SimpleExpression name = Restrictions.eq("name", "test");
    System.out.println(name);
  }
}
