package cn.kiroe.day03.method;

import java.util.Scanner;

/*
* 方法是Java代码中最常用的语法结构，这里对方法的语法做一下练习。

在使用方法或者想要写一个方法时，首先要考虑的是方法需要的参数是什么数据类型，需要几个（形式参数），再考虑方法需要返回什么结果（返回值类型）。在调用方法时，需要搞清楚具体传入什么数值（实际参数）。

实现以下需求：

使用for循环遍历n以内(包括n)的奇数，并计算所有的奇数的和并输出。

打印倒三角形，并且行数（line）是可控制的。比如我想打印6行的倒三角形，则如下图：

******
*****
****
***
**
*
根据键盘录入打印nn乘法表，n是可变的。

键盘录入一个int数字，判断它是奇数还是偶数。

根据键盘录入打印n行m列井号，n和m是可变的。

（扩展题）输出前n个数当中的所有素数，并统计个数。注：可以百度查一下如何求素数，该题作为扩展题，可以不做。
*
*
* */
public class MethodHomework {


    public static void main(String[] args) {
        //showOdd();
        //printInvertedTriangles();
        //multiplicationTable();
        //isEvenOrOdd();
        //printNumberSign();
        showPrime();
    }

    //（扩展题）输出前n个数当中的所有素数，并统计个数。注：可以百度查一下如何求素数，该题作为扩展题，可以不做。
    public static void showPrime() {
        System.out.println("--输出前n个数当中的所有素数，并统计个数--");
        Scanner in = new Scanner(System.in);
        System.out.print("请输入n:");
        int n = in.nextInt();
        int count = 0;
        in.close();
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                count++;
                System.out.print(i + " ");
                if (count % 10 == 0) {
                    System.out.println();
                }
            }

        }
        System.out.println("\n" + n + "前共有" + count + "个素数");
    }

    //判断素数 从1至 n的平方根
    public static boolean isPrime(int n) {

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //根据键盘录入打印n行m列井号，n和m是可变的。
    public static void printNumberSign() {
        System.out.println("--打印n行m列#--");
        Scanner in = new Scanner(System.in);
        System.out.print("请输入n m(1 2):");
        int n = in.nextInt();
        int m = in.nextInt();
        in.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    //键盘录入一个int数字，判断它是奇数还是偶数。
    public static void isEvenOrOdd() {
        System.out.println("判断奇偶");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        String result = !isEven(n) ? "奇数" : "偶数";
        System.out.println(n + "是 " + result);
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }


    //    使用for循环遍历n以内(包括n)的奇数，并计算所有的奇数的和并输出。
    public static void showOdd() {
        System.out.println("遍历n以内(包括n)的奇数，并计算所有的奇数的和");
        Scanner in = new Scanner(System.in);
        System.out.print("请输入n:");
        int n = in.nextInt();
        int sum = 0;
        for (int i = 1; i < n; i += 2) {
            System.out.print(i + " ");
            sum += i;

        }
        System.out.println("和为:" + sum);
        in.close();
    }

    /*

打印倒三角形，并且行数（line）是可控制的。比如我想打印6行的倒三角形，则如下图：

******
*****
****
***
**
*
     */
    public static void printInvertedTriangles() {
        System.out.println("--打印倒三角形--");
        System.out.print("请输入行数:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        in.close();
    }

    // 根据键盘录入打印nn乘法表，n是可变的。
    public static void multiplicationTable() {
        System.out.println("--打印nn乘法表--");
        System.out.print("请输入n:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + "=" + (i * j) + " \t");
            }
            System.out.println();
        }

    }


}
