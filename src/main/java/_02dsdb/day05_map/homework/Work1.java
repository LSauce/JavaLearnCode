package _02dsdb.day05_map.homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author kiro
 * @description:
 * @data 19:17 14/11/2023
 **/
/*
给定两个字符串s和t,
它们只包含小写字母。
字符串t是由s中的字母随机打乱之后，
在随机的一个位置添加一个字母生成的。
请找出那个添加的字母。
比如：
s = "abcd"
t = "baedc"
输出：e
 */
public class Work1 {
    public static void main(String[] args) {
        // 使用 H啊还是
       String s = "abcd";

       String t = "baedc";

        System.out.println("findAddedLetter(s,t) = " + findAddedLetter(s, t));
    }
    // null 不符合要求
    public static Character findAddedLetter(String s,String t){
        if(s == null || t == null){
            return null;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c,count+1);
        }

        // 遍历 t;
        for (char c : t.toCharArray()) {
            Integer count  = map.getOrDefault(c,0);
            if(count == 0){
                return c;
            }else{
                map.put(c,count-1);
            }
        }
        return null;
    }
}
