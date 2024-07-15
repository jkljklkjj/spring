package com.example.demo.Controller;

import com.example.demo.Map.Video;
import com.example.demo.Map.VideoLibrary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {
    @PostMapping("/video")
    public List<Video> getVideo(@RequestParam("CheckBox") String[] CheckBox) {
        System.out.println("接收到兴趣"+CheckBox);
        return VideoLibrary.getVideos(CheckBox);
    }
}
