package cn.kiroe.day15_string.homework.ex10;

/**
 * @author kiro
 * @description:
 * @data 20:46 30/10/2023
 **/

/*
判断一个字符串是否是对称字符串，例如"abc"不是对称字符串，"aba"、"abba"、"aaa"、"mnanm"是对称字符串。

提示: 判断一个字符串是否是对称的字符串，我只需要把第一个和最后一个比较，第二个和倒数第二个比较 ...

可以借助StringBuffer
 */
public class JudgeString {

    public static void main(String[] args) {
        System.out.println("判断对称字符串");
        String[] arrayString = {"abs","abba","aaa","mnanm","fdasdfs"};
        for (String s : arrayString) {
            System.out.println("symmetricalString( "+s+" ) = " + symmetricalString(s));
        }

    }

    public static boolean symmetricalString(String source) {

        char[] cs = source.toCharArray();
        for (int i = 0; i < cs.length / 2; i++) {
            if (cs[i] != cs[cs.length - i - 1]) {
                return false;
            }
        }

        return true;
    }
}
