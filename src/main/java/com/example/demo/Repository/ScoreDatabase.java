package com.example.demo.Repository;

import com.example.demo.Map.GlobalValue;
import com.example.demo.Map.ScoreRecord;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScoreDatabase {
    private final String url = GlobalValue.url;
    private final String username = GlobalValue.username;
    private final String password = GlobalValue.password;

    @PostConstruct
    public void init_Database() {
        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 创建数据库连接
            Connection conn = DriverManager.getConnection(url, username, password);

            // 创建Statement对象
            Statement stmt = conn.createStatement();

            // 执行SQL语句来创建用户表
            stmt.execute("CREATE TABLE IF NOT EXISTS users (username VARCHAR(50) PRIMARY KEY)");

            // 执行SQL语句来创建科目表
            stmt.execute("CREATE TABLE IF NOT EXISTS subjects (subject_name VARCHAR(50), username VARCHAR(50), PRIMARY KEY (subject_name, username), FOREIGN KEY (username) REFERENCES users(username))");

            // 执行SQL语句来创建成绩表
            stmt.execute("CREATE TABLE IF NOT EXISTS scores (id INT AUTO_INCREMENT, score DOUBLE, exam_date DATE, subject_name VARCHAR(50), username VARCHAR(50), PRIMARY KEY (id), FOREIGN KEY (subject_name, username) REFERENCES subjects(subject_name, username))");

            // 关闭连接
            conn.close();
        } catch (Exception e) {
            // 如果连接失败，打印出错误消息
            System.out.println("Failed to create the database.");
            e.printStackTrace();
        }
    }

    public void addUser(String username) throws SQLException {
        System.out.println("addUser");
        try (Connection conn = DriverManager.getConnection(url, this.username, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username) VALUES (?)")) {
            stmt.setString(1, username);
            stmt.executeUpdate();
        }
    }

    public void addSubject(String subjectname, String username) throws SQLException {
    try (Connection conn = DriverManager.getConnection(url, this.username, password);
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO subjects (subject_name, username) VALUES (?, ?)")) {
        stmt.setString(1, subjectname);
        stmt.setString(2, username);
        stmt.executeUpdate();
    }
}

    public void deleteUser(String username) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, this.username, password);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE username = ?")) {
            stmt.setString(1, username);
            stmt.executeUpdate();
        }
    }

    public void updateUser(String oldUsername, String newUsername) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, this.username, password);
             PreparedStatement stmt = conn.prepareStatement("UPDATE users SET username = ? WHERE username = ?")) {
            stmt.setString(1, newUsername);
            stmt.setString(2, oldUsername);
            stmt.executeUpdate();
        }
    }

    public void addScore(ScoreRecord scoreRecord) {
        try (Connection conn = DriverManager.getConnection(url, this.username, password)) {
            String username = scoreRecord.getUsername();
            String subject = scoreRecord.getSubject();
            double score = scoreRecord.getScore();

            // 检查用户是否存在
            String checkUserSql = "SELECT COUNT(*) FROM users WHERE username = ?";
            try (PreparedStatement checkUserStmt = conn.prepareStatement(checkUserSql)) {
                checkUserStmt.setString(1, username);
                ResultSet rs = checkUserStmt.executeQuery();
                if (!rs.next() || rs.getInt(1) == 0) {
                    System.out.println("User not found");
                    // 如果用户不存在，先添加这个用户
                    addUser(username);
                }
            }
            // 检查科目是否存在
            String checkSubjectSql = "SELECT COUNT(*) FROM subjects WHERE subject_name = ?";
            try (PreparedStatement checkSubjectStmt = conn.prepareStatement(checkSubjectSql)) {
                checkSubjectStmt.setString(1, subject);
                ResultSet rs = checkSubjectStmt.executeQuery();
                if (!rs.next() || rs.getInt(1) == 0) {
                    // 如果科目不存在，先添加这个科目
                    addSubject(subject, username);
                }
            }
            // 添加分数
            String insertScoreSql = "INSERT INTO scores (score, exam_date, subject_name, username) VALUES (?, ?, ?, ?)";
            try (PreparedStatement insertScoreStmt = conn.prepareStatement(insertScoreSql)) {
                insertScoreStmt.setDouble(1, score);
                insertScoreStmt.setDate(2, new java.sql.Date(scoreRecord.getTime().getTime()));
                insertScoreStmt.setString(3, subject);
                insertScoreStmt.setString(4, username);
                insertScoreStmt.executeUpdate();
            }
        } catch (SQLException e) {
            // handle exception
            e.printStackTrace();
        }
    }

    public List<ScoreRecord> selectScores(String username) throws SQLException {
        List<ScoreRecord> scores = new ArrayList<>();
        String sql = "SELECT subject_name, score, exam_date FROM scores WHERE username = ? ORDER BY subject_name, exam_date";

        try (Connection conn = DriverManager.getConnection(url, this.username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ScoreRecord scoreRecord = new ScoreRecord();
                scoreRecord.setSubject(rs.getString("subject_name"));
                scoreRecord.setScore(rs.getDouble("score"));
                scoreRecord.setTime(rs.getDate("exam_date"));
                scores.add(scoreRecord);
            }
        }
        System.out.println(scores);

        return scores;
    }

    public void insertScore(String username, String subject, double score, Date examDate) throws SQLException {
        //这个函数其次重要，因为我们需要根据用户名来插入用户的成绩
        String sql = "INSERT INTO scores (score, exam_date, subject_name, username) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, this.username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, score);
            stmt.setDate(2, new java.sql.Date(examDate.getTime()));
            stmt.setString(3, subject);
            stmt.setString(4, username);
            stmt.executeUpdate();
        }
    }
}