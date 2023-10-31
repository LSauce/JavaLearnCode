package cn.kiroe.day15_string._03api;

import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 14:53 30/10/2023
 **/
public class Ex4 {
    // 课堂练习：
    //	1:字符串helloWORLD
    //	2:第一个字符转为大写,其余字符转为小写     →   Helloworld
    public static void main(String[] args) {
        // 定义字符串
        String s = "helloWORLD";

        //func(s);

        String str = s.substring(0, 1).toUpperCase().
                concat(s.substring(1).toLowerCase());


        System.out.println(str);


        System.out.println("-----");
        Scanner scanner = new Scanner(System.in);
        /*
        课堂练习：
	1:字符串反转
	2:举例:
	键盘输入abc,反转后结果为cba
         */
        System.out.println("revert(scanner.nextLine()) = " + revert(scanner.nextLine()));


    }
    private static String revert(String string){
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(string.charAt(string.length()-i-1));
        }
        return stringBuilder.toString();
    }


    private static void func(String s) {
        // 第一个字符取出来 转换大写
        String head = s.substring(0, 1);
        String headStr = head.toUpperCase();

        // 把剩余的字符串取出来 转为小写的
        String remind = s.substring(1);
        String remindStr = remind.toLowerCase();

        // 把转换后的2部分进行拼接
        String newStr = headStr + remindStr;
        System.out.println(newStr);
    }
}
