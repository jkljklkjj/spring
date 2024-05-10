package com.example.demo.Controller;

import com.example.demo.Evaluator.Evaluator;
import com.example.demo.Speech.VoiceToText;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CountDownLatch;

import static com.example.demo.Crawler.PoemCrawler.crawlPoem;

@RestController
public class AudioController {
    private static String content;
    private VoiceToText voiceToText = new VoiceToText();
    private CountDownLatch latch = new CountDownLatch(1);

    @PostMapping("/audio")
    public String handleAudioUpload(@RequestParam("file") MultipartFile file) throws IOException, InterruptedException {
        System.out.println("接收到音频");
        Path tempFile = Files.createTempFile(null, null);
        file.transferTo(tempFile.toFile());

        // 运行ffmpeg命令将音频文件转换为PCM格式
        ProcessBuilder pb = new ProcessBuilder("ffmpeg", "-y", "-i", tempFile.toString(), "-acodec", "pcm_s16le", "-f", "s16le", "-ac", "1", "-ar", "16000", "src/main/resources/audio/test.pcm");
        Process process = pb.start();
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            System.out.println("Error occurred while executing ffmpeg command");
        }
        Files.delete(tempFile);

        try {
            voiceToText.setLatch(latch);
            voiceToText.run();
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while running VoiceToText";
        }
        String result = voiceToText.getResult();
        System.out.println(result);
        return Evaluator.run(content, result);
    }

    @GetMapping("/score")
    public String getScore(@RequestParam String score) {
        System.out.println("接收到分数文本");
//        return ScoreExcel
        return "1";
    }

    @PostMapping("/audiotest")
    public void up(@RequestParam("file") MultipartFile file) throws IOException, InterruptedException {
        System.out.println(file.getSize());
        System.out.println("接收到音频");
        try {
            file.transferTo(new File("D:/资料库/test.wav"));
            // rest of the code
        } catch (IOException e) {
            System.out.println("Error occurred while handling the file: " + e.getMessage());
        }
        System.out.println("音频上传成功");
    }

    @GetMapping("/poem")
    public String Poem(@RequestParam String title) throws IOException {
        System.out.println("接收到诗词请求");
        content = crawlPoem(title);
        return content;
    }

}
