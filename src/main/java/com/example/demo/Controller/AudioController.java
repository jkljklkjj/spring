package com.example.demo.Controller;

import com.example.demo.Speech.VoiceToText;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static com.example.demo.Crawler.PoemCrawler.crawlPoem;

@RestController
public class AudioController {
    @PostMapping("/audio")
    public String handleAudioUpload(@RequestParam("file") MultipartFile file) {
        File tmpFile = new File("src/main/resources/audio");
        if (!tmpFile.exists()) {
            return "File not found";
        }
        try {
            file.transferTo(tmpFile);
            System.out.println("文件已经放到了指定位置");
        } catch (IOException e) {
            e.printStackTrace();
        }
        VoiceToText voiceToText = new VoiceToText();
        voiceToText.setFile(tmpFile.toString());
        try {
            voiceToText.run();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while running VoiceToText";
        }
        return voiceToText.getResult();
    }

    @PostMapping("/audiotest")
    public void up(@RequestParam("file") MultipartFile file) {
        File tmpFile = new File("src/main/resources/audio");
        if(!tmpFile.exists()) tmpFile.mkdirs();
        System.out.println("音频上传成功");
    }

    @GetMapping("/poem")
    public String Poem(@RequestParam String title) throws IOException {
        System.out.println("接收到诗词请求");
        return crawlPoem(title);
    }

    @GetMapping("/test")
    public String test() throws IOException {
        System.out.println("test");
        return crawlPoem("静夜思");
    }
}
