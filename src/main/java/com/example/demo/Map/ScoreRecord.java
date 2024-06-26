package com.example.demo.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class ScoreRecord {
    @Id
    private String username = "testUser";
    private String subject;
    private double score;
    private Date time;

    @Override
    public String toString() {
        return "ScoreRecord{" +
                "username='" + username + '\'' +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                ", time=" + time +
                '}';
    }

    // getters and setters
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setTime(Date examDate) {
        this.time = examDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getScore() {
        return this.score;
    }

    public Date getTime() {
        return this.time;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getUsername() {
        return this.username;
    }
}