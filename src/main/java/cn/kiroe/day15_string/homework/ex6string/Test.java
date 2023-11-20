package cn.kiroe.day15_string.homework.ex6string;

/**
 * @author kiro
 * @description:
 * @data 19:41 30/10/2023
 **/
/*
对于字符串”woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun”

统计其中"java"字符串出现的次数。

提示：java出现了5次

提示：可以考虑使用indexOf方法，仅考虑本题举出的字符串，无需复杂考虑
 */
public class Test {

    public static void main(String[] args) {
       // String source = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        String source = "java";
        System.out.println("countOccurrences(source) = " + countOccurrences(source, "java"));
    }

    public static int countOccurrences(String source, String target) {
        int count = 0;
        int flag = -1;
        //朴素 解法
        while (flag != 0) {
            flag = source.indexOf(target, flag) + 1;
            count++;
        }
        return count - 1;
    }
}
