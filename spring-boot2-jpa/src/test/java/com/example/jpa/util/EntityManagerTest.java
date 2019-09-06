package com.example.jpa.util;

import com.example.jpa.model.Honey;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * @author Weijun Yu
 * @since 2019-09-06.
 */
public class EntityManagerTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(EntityManagerTest.class);

  @Test
  public void testSave() {
    EntityManager entityManager = InitSessionFactory.getEntityManager();
    Honey forestHoney = new Honey();
    forestHoney.setName("forest honey");
    forestHoney.setTaste("very sweet");

    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    entityManager.persist(forestHoney);

    LOGGER.info("honey id : {}", forestHoney.getId());
    transaction.commit();
    entityManager.close();
  }

}
