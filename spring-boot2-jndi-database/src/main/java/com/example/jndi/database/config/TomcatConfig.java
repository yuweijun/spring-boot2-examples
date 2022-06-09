package com.example.jndi.database.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.apache.tomcat.util.descriptor.web.ContextEnvironment;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
public class TomcatConfig {

    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {

        final TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory() {
            @Override
            protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
                tomcat.enableNaming();
                return super.getTomcatWebServer(tomcat);
            }

            @Override
            protected void customizeConnector(Connector connector) {
                logger.info("customizeConnector");
                int maxSize = 50000;
                super.customizeConnector(connector);
                connector.setMaxPostSize(maxSize);
                connector.setMaxSavePostSize(maxSize);
                if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {
                    logger.info("Set MaxSwallowSize " + maxSize);
                    ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(maxSize);
                }
            }

            @Override
            protected void postProcessContext(Context context) {
                ContextResource resource = new ContextResource();

                resource.setType(DataSource.class.getName());
                resource.setName("jdbc/mysql");

                // java.lang.IllegalArgumentException: jdbcUrl is required with driverClassName.
                //     at com.zaxxer.hikari.HikariConfig.validate(HikariConfig.java:1000)
                // resource.setProperty("factory", "com.zaxxer.hikari.HikariJNDIFactory");
                // resource.setProperty("factory", "com.zaxxer.hikari.");

                resource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");

                resource.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
                resource.setProperty("url", "jdbc:mysql://localhost/jdbc?allowPublicKeyRetrieval=true&verifyServerCertificate=false&characterEncoding=utf8&useSSL=false");
                resource.setProperty("username", "dbuser");
                resource.setProperty("password", "dbpass");

                context.getNamingResources().addResource(resource);
            }
        };

        factory.addContextCustomizers(context -> {
            // add a Context Environment
            ContextEnvironment ce = new ContextEnvironment();
            ce.setName("test/jndi");
            ce.setValue("This string come from TomcatServletWebServerFactory.addContextCustomizers() method : " + this.getClass().getName());
            ce.setType(String.class.getName());
            context.getNamingResources().addEnvironment(ce);
        });
        return factory;
    }

    @Bean
    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("java:/comp/env/jdbc/mysql");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();

        return (DataSource) bean.getObject();
    }

}
