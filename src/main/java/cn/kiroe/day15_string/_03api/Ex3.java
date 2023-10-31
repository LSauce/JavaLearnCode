package cn.kiroe.day15_string._03api;

import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 14:51 30/10/2023
 **/
public class Ex3 {


    public static void main(String[] args) {
//        获取一个用来表示字符串对象字符序列的，字节数组
//        byte[] getBytes()
//

//        获取的是用来表示字符串对象字符序列的，字符数组
//        char[] toCharArray()
//
//
//        把字符数组转换成字符串
//        static String valueOf(char[] chs)
//
//        把各种基本数据类型和对象转换成字符串  100---> "100"
//        static String valueOf(int i/double...)
//
//
//        把字符串全部转化为小写
//        String toLowerCase()
//
//        把字符串全部转换为大写
//        String toUpperCase()
//
//        字符串拼接，作用等价于 + 实现的字符串拼接
//        String concat(String str)


        String s = "abcd";
        // 获取一个用来表示字符串对象字符序列的，字节数组
        //byte[] getBytes()
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));
        //获取的是用来表示字符串对象字符序列的，字符数组
        //char[] toCharArray()
        char[] chars = s.toCharArray();
        System.out.println(Arrays.toString(chars));

        //把字符数组转换成字符串
        //static String valueOf(char[] chs)
        //
        //把各种基本数据类型和对象转换成字符串  100---> "100"
        //static String valueOf(int i/double...)
        String s1 = String.valueOf(100);
        System.out.println("s1 = " + s1);
        String s2 = String.valueOf(true);
        System.out.println("s2 = " + s2);

        //把字符串全部转化为小写
        //String toLowerCase()
        //
        //把字符串全部转换为大写
        //String toUpperCase()
        String s3 = s.toUpperCase();
        System.out.println("s3 = " + s3);

        //字符串拼接，作用等价于 + 实现的字符串拼接
        //String concat(String str)
        String s4 = s.concat("ef");
        System.out.println("s4 = " + s4);
    }
}
