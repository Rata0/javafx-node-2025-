package com.example.demopr.dao;

import com.example.demopr.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {
    private final Connection connection;

    public SupplierDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Supplier> getAllSupplier() throws SQLException {
        String sql = "SELECT * FROM partners;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<Supplier> suppliers = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                String director = resultSet.getString("director");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String inn = resultSet.getString("inn");
                int rating = resultSet.getInt("rating");

                Supplier supplier = new Supplier(id, type, name, director, email, phone, address, inn, rating);
                suppliers.add(supplier);
            }

            return suppliers;
        } catch (SQLException e) {
            throw new SQLException("Ошибка при получении данных о поставщиках", e);
        }
    }
}
