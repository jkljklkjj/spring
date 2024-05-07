package com.example.demo.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScoreRecord {
    @Id
    private String id;
    private String username;
    private String subject;
    private String score;
    private String time;
    private String email;
    // getters and setters
}