package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.example.demo.Crawler.PoemCrawler.crawlPoem;

@RestController
public class AudioController {
    @PostMapping("/audio")
    public String handleAudioUpload(@RequestParam("file") MultipartFile file) {
        try {
            byte[] audioBytes = file.getBytes();
            // TODO: Handle the audio data
            return "Received audio file";
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }

    @GetMapping("/test")
    public String test() throws IOException {
        return crawlPoem("静夜思");
    }
}
