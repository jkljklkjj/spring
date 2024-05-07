package com.example.demo.Service;

import com.example.demo.Map.ScoreRecord;
import com.example.demo.Repository.ScoreRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    private final ScoreRecordRepository scoreRecordRepository;

    public ScoreService(ScoreRecordRepository scoreRecordRepository) {
        this.scoreRecordRepository = scoreRecordRepository;
    }

    public List<ScoreRecord> getScoresByUsername(String username) {
        return scoreRecordRepository.findByUsername(username);
    }

    public ScoreRecord saveScore(ScoreRecord scoreRecord) {
        return scoreRecordRepository.save(scoreRecord);
    }
}