package com.example.demo.Evaluator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FuzzyPinyinConverter {
    private static final Map<String, String> fuzzyPinyinMap = new HashMap<>();

    static {
        fuzzyPinyinMap.put("zh", "z");
        fuzzyPinyinMap.put("ch", "c");
        fuzzyPinyinMap.put("sh", "s");
        fuzzyPinyinMap.put("l", "n");
        fuzzyPinyinMap.put("ng", "n");
        // 添加更多的模糊音对应关系
    }

    public static String convertToFuzzyPinyin(String pinyin) {
        for (Map.Entry<String, String> entry : fuzzyPinyinMap.entrySet()) {
            if (pinyin.contains(entry.getKey())) {
                pinyin = pinyin.replace(entry.getKey(), entry.getValue());
            }
        }
        return pinyin;
    }

    public static List<String> convertToFuzzyPinyin(List<String> pinyinList) {
        // 将一个拼音列表转换为模糊拼音列表
        return pinyinList.stream()
                .map(FuzzyPinyinConverter::convertToFuzzyPinyin)
                .collect(Collectors.toList());
    }
}