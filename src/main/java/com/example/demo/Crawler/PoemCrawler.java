package com.example.demo.Crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static java.sql.DriverManager.println;

public class PoemCrawler {
    public static String crawlPoem(String title) throws IOException {
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
        return poemContent.html();
    }
}
