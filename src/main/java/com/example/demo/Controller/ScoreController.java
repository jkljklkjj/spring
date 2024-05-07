package com.example.demo.Controller;

import com.example.demo.Map.ScoreRecord;
import com.example.demo.Service.ScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/getscore/{username}")
    public List<ScoreRecord> getScore(@PathVariable String username) {
        return scoreService.getScoresByUsername(username);
    }

    @PostMapping("/score")
    public ScoreRecord saveScore(@RequestBody ScoreRecord scoreRecord) {
        return scoreService.saveScore(scoreRecord);
    }
}