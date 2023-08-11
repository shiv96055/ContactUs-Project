package com.contactUsProject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.contactUsProject.model.Request;

public class RequestDao {

    private static String jdbcUrl = "jdbc:postgresql://localhost:5432/contactus_project";
    private static String username = "postgres";
    private static String password = "admin";

    public RequestDao() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static  void insertRequest(Request request) throws SQLException {
        String insertQuery = "INSERT INTO userData (name, email, message) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, request.getName());
            preparedStatement.setString(2, request.getEmail());
            preparedStatement.setString(3, request.getMessage());
            preparedStatement.executeUpdate();
        }
    }

    public static List<Request> fetchRequests(boolean isActive) {
        List<Request> requests = new ArrayList<>();
        String selectQuery = "SELECT * FROM userData WHERE active = ?";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setBoolean(1, isActive);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Request request = new Request();
                    request.setId(resultSet.getInt("id"));
                    request.setName(resultSet.getString("name"));
                    request.setEmail(resultSet.getString("email"));
                    request.setMessage(resultSet.getString("message"));
                    requests.add(request);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public static void changeStatus(int requestId, boolean status) {
        String updateQuery = "UPDATE userData SET active = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setBoolean(1, status);
            preparedStatement.setInt(2, requestId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
