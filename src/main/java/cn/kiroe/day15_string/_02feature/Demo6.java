package cn.kiroe.day15_string._02feature;

/**
 * @author kiro
 * @description:
 * @data 11:11 30/10/2023
 **/
public class Demo6 {
    /*

    - 当参与字符串拼接对的2个字符串,
      只要有1个引用变量的形式出现时,则会在堆上创建新的字符串对象.
      - 原因是因为参与了运算,无法在编译期确定其值,
        就不能在编译时期加入常量池


- 只有参与字符串拼接的2个字符串都是字面值常量的时候
  - 如果常量池中已有该字符串对象的引用,则返回常量池中的引用
  - 如果常量池中没有,则在堆上创建,并把引用放入常量池
     */
    public static void main(String[] args) {
        // 有变量参加 则 创建新String
        // 只有 字面常量创建 不创建新的
        // 字符串的拼接
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo"; // 不会创建
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;




        System.out.println(s1 == s2);// true
        System.out.println(s1 == s3);//         true
        System.out.println(s1 == s4);// false
        System.out.println(s1 == s9);// false
        System.out.println(s4 == s5);// false

    }
}
