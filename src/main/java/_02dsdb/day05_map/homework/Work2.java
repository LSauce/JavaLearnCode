package _02dsdb.day05_map.homework;

import java.util.HashMap;

/**
 * @author kiro
 * @description:
 * @data 19:25 14/11/2023
 **/

/*
给定一个字符串数组 words 和一个字符串 chars.
如果一个字符串能被 chars 里面的字符组成，
那么这个字符串就是"好"的(chars里面每个字符只能使用一次)。
求：words 里面所有好的字符串的字符总个数。

比如：
words = ["cat", "bt", "hat", "tree"]
chars = "atach"
好的字符串有 "cat", "hat", 3 + 3 = 6.
输出：6

注意1:
List的效率 在O(n)
HashMap的效率大致在 O(1)
注意2：
    要提取方法 ，内部 清晰明了，
    将问题分解，问题也更容易解决

 */
public class Work2 {
    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        // 如果一个字符串能被 chars 里面的字符组成，
        // 这个字符串就是"好"的
        System.out.println("getGoodStringTotalLength(words,chars) = " + getGoodStringTotalLength(words, chars));
    }

    // 求：words 里面所有好的字符串的字符总个数。
    public static int getGoodStringTotalLength(String[] words, String chars) {
        if (words == null || chars == null) {
            return 0;
        }
        int countLength = 0;
        // 判断是否为好 字符串
        for (String word : words) {
            // 单一判断原则，低耦合 高内聚
            if (isGoodString(word, chars)) {
                countLength += word.length();
            }

        }
        return countLength;

    }

    public static boolean isGoodString(String word, String chars) {
        if (word == null || chars == null) {
            return false;
        }
        // 统计 chars中的 字符
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        // Link 要先迭代到 对应位置，所以效率和 ArrayList的整体移动，效率差不多
        // 判断是否  为好
        for (char c : word.toCharArray()) {
            // 直接使用 get，不用遍历两次了
            Integer count = map.getOrDefault(c, 0);
            // 当值为没有了，返回false
            if (count == 0) {
                return false;
            }
            map.put(c, count - 1);

        }

        return true;

    }

}
