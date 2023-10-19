package cn.kiroe.day06.oop1.homework;

import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 19:55 17/10/2023
 **/
public class RecursionExercise {
    /*

    练习使用递归
递归在实际开发中用途并不广泛，但我们仍有必要学习它的基本使用。

这道题目如果想不明白，那就百度一下吧。

 使用递归，把十进制正整数（N>=0）转换成二进制数
     */

    public static String decimalToBinary(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        if (n == -1) {
            return "-1";
        }

        return decimalToBinary(n >> 1) + (n & 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("---十进制转二进制---");
        System.out.print("请输入 一个整数:");
        int n = in.nextInt();
        System.out.println(decimalToBinary(n));
    }
}
