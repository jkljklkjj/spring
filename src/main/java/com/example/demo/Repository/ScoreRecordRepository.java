package com.example.demo.Repository;

import com.example.demo.Map.ScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRecordRepository extends JpaRepository<ScoreRecord, String> {
    List<ScoreRecord> findByUsername(String username);
}