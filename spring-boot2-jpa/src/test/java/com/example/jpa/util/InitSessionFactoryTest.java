package com.example.jpa.util;


import com.example.jpa.model.Bee;
import com.example.jpa.model.Honey;
import com.example.jpa.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Weijun Yu
 * @since 2019-09-06.
 */
public class InitSessionFactoryTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(InitSessionFactoryTest.class);

  // private SessionFactory sessionFactory = InitSessionFactory.getSessionFactory("hibernate.cfg.example.xml");
  private SessionFactory sessionFactory = InitSessionFactory.getSessionFactory("hibernate.cfg.hikari.xml");

  @Test
  public void test1() {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();

    User user = User.builder()
        .name("yu")
        .mobile("mobile")
        .nickName("test")
        .createTime(new Date())
        .updateTime(new Date())
        .build();
    session.save(user);
    LOGGER.info("user.id is : {}", user.getId());

    transaction.commit();
    session.close();

    try (Session session2 = sessionFactory.openSession()) {
      List<User> students = session2.createQuery("from User", User.class).list();
      students.forEach(s -> LOGGER.info("user nickname is : {}", s.getNickName()));
    } catch (Exception e) {
      LOGGER.error("query error", e);
    }
  }

  @Test
  public void test2() {
    clean();
    createHoney();
    createRelation();
    delete();
    update();
    query();
  }

  private  Honey createHoney() {
    Honey forestHoney = new Honey();
    forestHoney.setName("forest honey");
    forestHoney.setTaste("very sweet");
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.save(forestHoney);
    tx.commit();
    session.close();
    return forestHoney;
  }

  private  void update() {
    Honey honey = createHoney();
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    honey.setName("Modern style");
    session.update(honey);
    tx.commit();
    session.close();
  }

  private  void delete() {
    Honey honey = createHoney();
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.delete(honey);
    tx.commit();
    session.close();
  }

  private  void clean() {
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.createQuery("delete from Bee").executeUpdate();
    session.createQuery("delete from Honey").executeUpdate();
    tx.commit();
    session.close();
  }

  /**
   * 不用 lombok 生成的 Bee/Honey 的 equals/hashCode 方法，避免死循环
   */
  private  void createRelation() {
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    Honey honey = new Honey();
    honey.setName("country honey");
    honey.setTaste("Delicious");
    session.save(honey);

    Bee bee = new Bee("Sebastian");
    bee.setHoney(honey);
    session.save(bee);

    /* create the relation on both sides */
    honey.getBees().add(bee);

    LOGGER.info("get bee honey : {}", bee.getHoney());
    tx.commit();
    session.close();
  }

  private  void query() {
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    List honeys = session.createQuery("select h from Honey as h").list();
    for (Iterator iter = honeys.iterator(); iter.hasNext(); ) {
      Honey element = (Honey) iter.next();
      LOGGER.debug("honey : {}", element);
    }
    tx.commit();
    session.close();
  }
}