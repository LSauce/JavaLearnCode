package cn.kiroe.day15_string.homework.qustion;

/**
 * @author kiro
 * @description:
 * @data 13:55 31/10/2023
 **/
public class Demo {
    public static void main(String[] args) {
        String s = new String("abc");
        System.out.println("(s.intern() == s) = " + (s.intern() == s));
        // String s1 = "a";
        // String s2 =  "1" + s1; // 没有加入 常量池
        // // s2.intern();
        // String s3 = "1a";
        // System.out.println("(s3.intern() == s2) = " + (s3.intern() == s2));
        //
        // String s4 = new String(s2.substring(0,1));
        // System.out.println("(s4.intern() == s4) = " + (s4.intern() == "1"));
    }
}
