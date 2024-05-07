package com.example.demo.Evaluator;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.*;

public class Evaluator {

    public static List<String> PinyinTransform(String content) {
        //把诗歌内容转换为拼音列表，并匹配模糊音
        content = content.replace("<br>", "");
        List<String> pinyinList = new ArrayList<>();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);

        for (char c : content.toCharArray()) {
            if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                try {
                    String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
                    if (pinyinArray != null && pinyinArray.length > 0) {
                        pinyinList.add(pinyinArray[0]);
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinList.add(Character.toString(c));
            }
        }
        pinyinList = FuzzyPinyinConverter.convertToFuzzyPinyin(pinyinList);
        return pinyinList;
    }

    public static List<Integer> getMatchingIndexes(List<String> list1, List<String> list2) {
        //list1是原诗的拼音列表，list2是背诵结果的拼音列表
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    indexes.add(i);
                    break;
                }
            }
        }
        return indexes;  // 返回空列表表示没有找到匹配的元素
    }

    public static String addBrackets(String str, List<Integer> indexes) {
        //在原诗中添加括号，标记出背诵结果中的错误
        Collections.sort(indexes);  // 确保索引列表是排序的
        StringBuilder result = new StringBuilder(str);  // 创建一个新的StringBuilder以避免修改原始字符串

        List<String> strList = new ArrayList<>();
        for (char c : str.toCharArray()) {
            //把诗中每一个字放进数组
            strList.add(String.valueOf(c));
        }

        for(int i = 0;i<result.length();i++){
            if(indexes.contains(i)){
                strList.set(i, "(" + strList.get(i) + ")");
            }
        }

        String newStr = String.join("", strList);
        return newStr.replace(")(", "");
    }

    public static double jaccardSimilarity(List<String> list1, List<String> list2) {
        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / union.size();
    }

    public static String PoemEvaluateRate(String result, String content) {
        //接收背诵结果和原诗内容，返回相似度
        List<String> Result = PinyinTransform(content);
        List<String> Content = PinyinTransform(result);

        double x = jaccardSimilarity(Result, Content);
        x *= 100;
        String y = String.format("%.1f", x);

        return y + "%" ;
    }

    public static void main(String[] args) {
        //新知识点：可以在一个类里面直接创建主函数来进行测试
        String content = "白日依山尽，黄河入海流。欲穷千里目，更上一层楼。";
        String result = "白日依山尽。黄河入海流，欲穷千里目，上一层楼。";//这里是背诵结果
        System.out.println(PoemEvaluateRate(result, content));

        System.out.println(PinyinTransform(content));
        List<String> pinyinList = PinyinTransform(content);
        List<String> hapinyinList = PinyinTransform(result);
        List<Integer> index = getMatchingIndexes(pinyinList, hapinyinList);
        System.out.println(index);
        System.out.println(addBrackets(content, index));
    }

    public static String run(String content, String result) {
        //原内容和背诵结果
        System.out.println(PoemEvaluateRate(result, content));

        List<String> pinyinList = PinyinTransform(content);
        List<String> hapinyinList = PinyinTransform(result);
        List<Integer> index = getMatchingIndexes(pinyinList, hapinyinList);
        String Result = addBrackets(content, index);
        System.out.println(Result);
        String CorrectRate = PoemEvaluateRate(result, content);
        return CorrectRate+ " " + Result;
    }
}
