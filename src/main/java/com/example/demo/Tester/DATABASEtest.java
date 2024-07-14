package com.example.demo.Tester;

import java.sql.*;

import com.example.demo.Map.GlobalValue;

public class DATABASEtest {
    static String url = GlobalValue.url;
    static String username = GlobalValue.username;
    static String password = GlobalValue.password;

    public static void init_UserDatabase() {
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

    public static void init_ScoreDatabase() {
        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 创建数据库连接
            Connection conn = DriverManager.getConnection(url, username, password);

            // 创建Statement对象
            Statement stmt = conn.createStatement();

            // 执行SQL语句来创建用户表
            stmt.execute("CREATE TABLE IF NOT EXISTS users (username VARCHAR(50) PRIMARY KEY, password VARCHAR(255))");

            // 执行SQL语句来创建科目表
            stmt.execute("CREATE TABLE IF NOT EXISTS subjects (subject_name VARCHAR(50), username VARCHAR(50), PRIMARY KEY (subject_name, username), FOREIGN KEY (username) REFERENCES users(username))");

            // 执行SQL语句来创建成绩表
            stmt.execute("CREATE TABLE IF NOT EXISTS scores (id INT AUTO_INCREMENT, score DOUBLE, exam_date DATE, subject_name VARCHAR(50), username VARCHAR(50), PRIMARY KEY (id), FOREIGN KEY (subject_name, username) REFERENCES subjects(subject_name, username))");

            // 关闭连接
            conn.close();
        } catch (Exception e) {
            // 如果连接失败，打印出错误消息
            System.out.println("分数数据库创建失败");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        init_UserDatabase();
        init_ScoreDatabase();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 尝试创建数据库连接
            System.out.println("Connected to the database successfully!");

            // 使用连接执行查询
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW TABLES");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            // 如果连接失败，打印出错误消息
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}