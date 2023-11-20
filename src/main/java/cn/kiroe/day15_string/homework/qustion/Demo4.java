package cn.kiroe.day15_string.homework.qustion;

/**
 * @author kiro
 * @description:
 * @data 14:50 31/10/2023
 **/
public class Demo4 {

    public static void main(String[] args) {

        String a = "a";
        String b = a + "bc"; // 只会在执行过后才会加入,进行判断查看是否存在，再尝试加入
        System.out.println("(b.intern() == b) = " + (b.intern() == b));
        String c = "abc";
        System.out.println("(c.intern() == b) = " + (c.intern() == c));
    }
}
