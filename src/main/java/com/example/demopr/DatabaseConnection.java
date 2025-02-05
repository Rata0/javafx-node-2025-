package com.example.demopr;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/gia";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    private Connection connection;

    public DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("!!!!!!!!!!!!!!!!");
        } catch (SQLException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
        }
    }
}
