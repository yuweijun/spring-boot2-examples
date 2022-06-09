package com.example.dit.repository;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author yuweijun 2022-06-07.
 */
public class MysqlConnectionTest {

    @Test
    public void testCase() {
        String url = "jdbc:mysql://192.168.31.82/jdbc?allowPublicKeyRetrieval=true&verifyServerCertificate=false&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "root";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Database connection is successful !!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
