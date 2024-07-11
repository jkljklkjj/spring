package com.example.demo.Tester;

import java.sql.Connection;
import java.sql.DriverManager;

public class DATABASEtest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "123456";

        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 尝试创建数据库连接
            Connection conn = DriverManager.getConnection(url, username, password);

            // 如果连接成功，打印出成功消息
            System.out.println("Connected to the database successfully!");

            // 关闭连接
            conn.close();
        } catch (Exception e) {
            // 如果连接失败，打印出错误消息
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}