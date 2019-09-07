package com.example.jpa.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author Weijun Yu
 * @since 2019-09-05.
 */
public class InitSessionFactory {

  private static StandardServiceRegistry serviceRegistry;

  private static SessionFactory sessionFactory;

  public static synchronized SessionFactory getSessionFactory(String config) {
    if (sessionFactory == null) {
      try {
        // 1. Create serviceRegistry using default configuration file : hibernate.cfg.xml
        // serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        serviceRegistry = new StandardServiceRegistryBuilder().configure(config).build();

        // 2. Create MetadataSources
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);

        // 3. Create Metadata
        Metadata metadata = metadataSources.getMetadataBuilder().build();

        // 4. Create SessionFactory
        sessionFactory = metadata.getSessionFactoryBuilder().build();
      } catch (Exception e) {
        e.printStackTrace();
        if (serviceRegistry != null) {
          StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
      }
    }

    return sessionFactory;
  }

  public static EntityManager getEntityManager(Session session) {
    EntityManagerFactory entityManagerFactory = session.getEntityManagerFactory();
    return entityManagerFactory.createEntityManager();
  }

  public static void shutdown() {
    if (serviceRegistry != null) {
      StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
  }
}