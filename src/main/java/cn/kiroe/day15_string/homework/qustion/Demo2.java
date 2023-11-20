package cn.kiroe.day15_string.homework.qustion;

/**
 * @author kiro
 * @description:
 * @data 14:40 31/10/2023
 **/
public class Demo2 {

    public static void main(String[] args) {

        String s1 = "a";
        String s2 = s1 + "b";
        System.out.println("(s2.intern() == s2) = " + (s2.intern() == s2));
        String s5 = "java";
        String s3 = "j";
        String s4 = s3 + "ava";
        System.out.println("(s4.intern() == s4) = " + (s4.intern() == s4));

    }
}
