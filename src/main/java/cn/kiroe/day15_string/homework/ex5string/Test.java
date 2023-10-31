package cn.kiroe.day15_string.homework.ex5string;

/**
 * @author kiro
 * @description:
 * @data 19:34 30/10/2023
 **/

/*

把字符串"legendary"中字符 改成间隔大写小写模式，

即 "LeGeNdArY"

提示:

借助API

Character.toUpperCase把字符转换成大写
 */
public class Test {
    public static void main(String[] args) {
        String source = "legendary";
        System.out.println("changeToIntervalCase(source) = " + changeToIntervalCase(source));
    }

    public static String changeToIntervalCase(String sourceString) {
        char[] cs = sourceString.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            if ((i & 1) == 0 && Character.isLowerCase(cs[i])) {
                cs[i] = Character.toUpperCase(cs[i]);
            } else if ((i & 1) == 0 && Character.isUpperCase(cs[i])) {
                cs[i] = Character.toLowerCase(cs[i]);

            }
        }
        return new String(cs);
    }

}
