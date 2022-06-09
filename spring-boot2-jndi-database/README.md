# Exception: jdbcUrl is required with driverClassName.

when using Hikari JNDI factory

    resource.setProperty("factory", "com.zaxxer.hikari.HikariJNDIFactory");

server start failed:

    java.lang.IllegalArgumentException: jdbcUrl is required with driverClassName.
         at com.zaxxer.hikari.HikariConfig.validate(HikariConfig.java:1000)

## Fix

Change to tomcat-jdbc datasource

    resource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");

# access link

    test jdbc jndi: http://localhost:8080/
    test string jndi: http://localhost:8080/jndi

# References:

1. https://www.baeldung.com/spring-boot-tomcat-connection-pool
2. https://github.com/spring-projects/spring-boot/issues/12758