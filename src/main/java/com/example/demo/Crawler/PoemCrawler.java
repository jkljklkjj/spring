package com.example.demo.Crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.example.demo.Evaluator.Evaluator;

public class PoemCrawler {
    private static Evaluator evaluator = new Evaluator();
    public static String crawlPoem(String title) throws IOException {
        //接收诗词标题，返回诗词内容
        if(title.length()<2) return "诗词标题过短，请输入完整标题";
        String FirstWord = title.substring(0, 1);
        title = URLEncoder.encode(title, StandardCharsets.UTF_8);
        FirstWord = URLEncoder.encode(FirstWord, StandardCharsets.UTF_8);
        Document doc = Jsoup.connect("https://so.gushiwen.cn/search.aspx")
                .data("value", title)
                .data("valuej", FirstWord)
                .get();
        Element firstPoem = doc.selectFirst(".sons");
        Element poemContent = null;
        if (firstPoem != null) {
            poemContent = firstPoem.selectFirst(".contson");
        }
        String text = poemContent.text();
        String newText = text.replaceAll("\\(.*?\\)", "");
        newText = newText.replaceAll(" ", "<br>");
        System.out.println(evaluator.PinyinTransform(newText));
        return newText;
    }
}
