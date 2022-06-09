package com.example.vault;

import com.example.vault.config.VaultExampleConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(VaultExampleConfiguration.class)
public class VaultIntegrationApplication implements CommandLineRunner {

    @Autowired
    private VaultExampleConfiguration configuration;

    // public VaultIntegrationApplication(ValutExampleConfiguration configuration) {
    //     this.configuration = configuration;
    // }

    public static void main(String[] args) {
        SpringApplication.run(VaultIntegrationApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Logger logger = LoggerFactory.getLogger(VaultIntegrationApplication.class);

        logger.info("----------------------------------------");
        logger.info("Configuration properties");
        logger.info("   example.username is {}", configuration.getUsername());
        logger.info("   example.password is {}", configuration.getPassword());
        logger.info("----------------------------------------");
    }
}
