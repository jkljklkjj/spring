package com.example.demo;

import com.example.demo.Evaluator.Evaluator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static com.example.demo.Crawler.PoemCrawler.crawlPoem;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws IOException {
        Evaluator evaluator = new Evaluator();
//        List<String> pinyinList = evaluator.PinyinTransform("��ǰ���¹⣬���ǵ���˪����ͷ�����£���ͷ˼���硣");
//        System.out.println(pinyinList);
        System.out.println(1);
    }

}