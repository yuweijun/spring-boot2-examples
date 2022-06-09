package com.example.vault.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Weijun Yu
 * @since 2022-05-18
 */
@ConfigurationProperties("com.example")
public class VaultExampleConfiguration {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}