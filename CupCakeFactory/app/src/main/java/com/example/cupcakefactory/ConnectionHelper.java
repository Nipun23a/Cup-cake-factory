package com.example.cupcakefactory;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionHelper {

    private String ip = "localhost";
    private String database = "cake_factory";
    private String uname = "root";
    private String pass = "1234";
    private String port = "3306";

    public Connection connectionClass() {
       Connection conn = null;
       try {
           Class.forName("com.mysql.jdbc.Driver");
           String connectionString = "jdbc:mysql://" + ip + ":" + port + "/" + database;
           conn = DriverManager.getConnection(connectionString, uname, pass);

       }catch (Exception e){
           Log.e("ERRO", Objects.requireNonNull(e.getMessage()));
       }
       return conn;
    }
    public boolean insertUser(String email, String name,String password) {
        Connection connection = connectionClass();
        if (connection != null) {
            try {
                String query = "INSERT INTO users (email,username,userpassword) VALUES (?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, password);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public boolean isUserValid(String email, String password) {
        Connection connection = connectionClass();
        if (connection != null) {
            try {
                String query = "SELECT * FROM users WHERE email = ? AND userpassword = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next(); // Returns true if a matching row is found
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    public boolean isAdminValid(String adminusername, String password) {
        Connection connection = connectionClass();
        if (connection != null) {
            try {
                String query = "SELECT * FROM admins WHERE adminusername = ? AND adminpassword = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, adminusername);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next(); // Returns true if a matching row is found
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}


