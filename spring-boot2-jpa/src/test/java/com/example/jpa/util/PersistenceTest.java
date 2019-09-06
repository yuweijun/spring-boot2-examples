package com.example.jpa.util;

import com.example.jpa.model.Bee;
import com.example.jpa.model.Honey;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Iterator;
import java.util.List;

/**
 * @author Weijun Yu
 * @since 2019-09-06.
 */
public class PersistenceTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceTest.class);

  private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.example.jpa.model");

  @Test
  public void test1() {
    clean();
    createHoney();
    createRelation();
    delete();
    update();
    query();
  }

  private static Honey createHoney() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();

    Honey forestHoney = new Honey();
    forestHoney.setName("forest honey");
    forestHoney.setTaste("very sweet");
    entityManager.persist(forestHoney);

    LOGGER.info("honey id : {}", forestHoney.getId());
    transaction.commit();
    entityManager.close();
    return forestHoney;
  }

  private static void update() {
    createHoney();

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    Honey honey = (Honey) entityManager.createQuery("select h from Honey as h").getResultList().get(0);
    honey.setName("Honey name");
    transaction.commit();
    entityManager.close();
  }

  private static void delete() {
    createHoney();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();

    Honey honey = (Honey) entityManager.createQuery("select h from Honey as h").getResultList().get(0);
    entityManager.remove(honey);
    transaction.commit();
    entityManager.close();
  }

  private static void clean() {
    createHoney();

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    entityManager.createQuery("delete from Bee").executeUpdate();
    entityManager.createQuery("delete from Honey").executeUpdate();
    transaction.commit();
    entityManager.close();
  }

  private static void createRelation() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();

    Honey honey = new Honey();
    honey.setName("country honey");
    honey.setTaste("Delicious");
    entityManager.persist(honey);

    Bee bee = new Bee("Sebastian");
    bee.setHoney(honey);
    entityManager.persist(bee);

    /* create the relation on both sides */
    honey.getBees().add(bee);
    LOGGER.info("get bee honey : {}", bee.getHoney());
    transaction.commit();
    entityManager.close();
  }

  private static void query() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    List<Honey> honeys = entityManager.createQuery("select h from Honey as h").getResultList();
    for (Iterator iter = honeys.iterator(); iter.hasNext(); ) {
      Honey element = (Honey) iter.next();
      LOGGER.debug("honey : {}", element);
    }
    transaction.commit();
    entityManager.close();
  }
}
