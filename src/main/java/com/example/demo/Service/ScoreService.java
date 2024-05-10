package com.example.demo.Service;

import com.example.demo.Map.ScoreRecord;
import com.example.demo.Repository.ScoreDatabase;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class ScoreService {
    private final ScoreDatabase scoreRecordRepository;

    public ScoreService(ScoreDatabase scoreRecordRepository) {
        this.scoreRecordRepository = scoreRecordRepository;
    }

    public List<ScoreRecord> getScoresByUsername(String username) {
        try {
            return scoreRecordRepository.selectScores(username);
        } catch (SQLException e) {
            // handle exception
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void addUser(String username) {
        try {//添加用户
            scoreRecordRepository.addUser(username);
        } catch (SQLException e) {
            // handle exception
            e.printStackTrace();
        }
    }

    public void addScore(ScoreRecord scoreRecord) {
        try {//添加分数
            scoreRecordRepository.addScore(scoreRecord);
        } catch (SQLException e) {
            // handle exception
            e.printStackTrace();
        }
    }

//    public ScoreRecord saveScore(ScoreRecord scoreRecord) {
//        return scoreRecordRepository.save(scoreRecord);
//    }
}