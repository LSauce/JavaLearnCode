package cn.kiroe.day15_string._02feature;

/**
 * @author kiro
 * @description:
 * @data 10:34 30/10/2023
 **/
public class Demo4 {

    public static void main(String[] args) {
       // 一： 先直接赋值 在通过构造方法
        String s = "abc";
        // 使用的为相同数组，直接调用
        String s2 = new String("abc");
        System.out.println(s == s2);
        // 二： 先构造方法创建对象，在直接赋值
        String s3 = new String(new char[]{'a','b','c'});

        String s4 = "abc";
        System.out.println(s3.toCharArray() == s4.toCharArray());
        String s5 =  s3.intern();
        System.out.println("s5 = " + s5);
        s5.hashCode();
    }
}
