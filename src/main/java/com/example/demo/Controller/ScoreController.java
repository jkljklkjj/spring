package com.example.demo.Controller;

import com.example.demo.Map.ScoreRecord;
import com.example.demo.Service.ScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/get")
    public List<ScoreRecord> getScoresByUsername(@RequestParam String username) {
        System.out.println(username);
        return scoreService.getScoresByUsername(username);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestParam String username) {
        scoreService.addUser(username);
    }

    @PostMapping("/add")
    public void addScore(@RequestBody ScoreRecord scoreRecord) {

        scoreService.addScore(scoreRecord);
    }

}