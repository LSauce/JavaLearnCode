package _02dsdb.day06_map.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kiro
 * @description:
 * @data 13:56 15/11/2023
 **/
/*
"aababcabcdabcde",获取字符串中每一个字母出现的次数要求结果:a(5)b(4)c(3)d(2)e(1)


 */

public class Work1 {
    public static void main(String[] args) {
        // "aababcabcdabcde",获取字符串中每一个字母出现的次数要求结果:a(5)b(4)c(3)d(2)e(1)
        String source = "aababcabcdabcde";
        Map<Character,Integer> lfs =  getLetterFrequencyStatistics(source);
        System.out.println("lfs = " + lfs);
    }

    public static Map<Character,Integer> getLetterFrequencyStatistics(String source){
        if(source == null){
            return null;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : source.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c,count+1);
        }
        return map;
    }
}
