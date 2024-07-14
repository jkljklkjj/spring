package com.example.demo.Repository;

import com.example.demo.Map.GlobalValue;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class Login {
    private final String url = GlobalValue.url;
    private final String username = GlobalValue.username;
    private final String password = GlobalValue.password;

    @PostConstruct
    public void init_Database() {
        //初始化数据库
        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered.");

            // 使用try-with-resources确保资源正确关闭
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement()) {

                // 创建用户表，合并用户名和密码列
                stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                        "username VARCHAR(50) PRIMARY KEY, " +
                        "password VARCHAR(255))"); // 注意：实际应用中应对密码进行加密处理
                System.out.println("Users table created or already exists.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to create the database.");
            e.printStackTrace();
        }
    }

    public String addUser(String user_name, String pass_word) {
        System.out.println("addUser");
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement checkUserExists = conn.prepareStatement("SELECT username FROM users WHERE username = ?");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)")) {

            // 检查用户是否已存在
            checkUserExists.setString(1, user_name);
            ResultSet rs = checkUserExists.executeQuery();
            if (rs.next()) {
                return "用户名已存在";
            }

            // 在实际应用中，应对密码进行加密处理
            stmt.setString(1, user_name);
            stmt.setString(2, pass_word);
            stmt.executeUpdate();
            return "注册成功";
        } catch (SQLException e) {
            System.out.println("Failed to add user.");
            e.printStackTrace();
            return "注册失败";
        }
    }

    public String login(String user_name, String pass_word) {
        System.out.println("login");
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // 首先检查用户是否存在
            try (PreparedStatement checkUserStmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?")) {
                checkUserStmt.setString(1, user_name);
                ResultSet userRs = checkUserStmt.executeQuery();
                if (!userRs.next()) {
                    return "用户不存在";
                }
            }

            // 检查用户名和密码是否匹配
            try (PreparedStatement loginStmt = conn.prepareStatement("SELECT * FROM passwords WHERE username = ? AND password = ?")) {
                loginStmt.setString(1, user_name);
                loginStmt.setString(2, pass_word);
                ResultSet loginRs = loginStmt.executeQuery();
                if (loginRs.next()) {
                    return "登陆成功";
                } else {
                    return "密码不正确";
                }
            }
        } catch (SQLException e) {
            System.out.println("登陆失败");
            e.printStackTrace();
            return "Failed to login due to an error.";
        }
    }
}