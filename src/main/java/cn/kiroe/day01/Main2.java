package cn.kiroe.day01;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        /*
        boolean b1 = true;
        int a = b1;
        int c = (int) b1;*/
        /*
        float flo = 20.2f;
        double d = flo;
        System.out.println(flo);//20.2
        System.out.println(d);//20.200000762939453
        */

        float f1 = 0.2f;
        float f2 = 0.3f;
        double dou1 = 0.2;
        byte by1 = 127;
        byte by2 = 127;
        byte by3 = (byte) (by1 + by2);
        char c1 = '1';
        char c2 = '3';
        char c3 = (char) (c1 + c2);
        // 计算 2 + 4 + 6 + … + 100 的值
        int sum = 0;
        for (int i = 2; i <= 100; i += 2) {
            sum += i;
        }
        System.out.println("2 + 4 + 6 + ... + 100 的值为：" + sum);

        // 计算2000年1月1日到2008年1月1日相距多少天（注意闰年）
        LocalDate startDate = LocalDate.of(2000, 1, 1);
        LocalDate endDate = LocalDate.of(2008, 1, 1);
        long daysBetween2 = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("2000年1月1日到2008年1月1日相距的天数为：" + daysBetween2);

        long daysBetween = 0;
        for (int year = 2000; year < 2008 ; year++) {
            if(isLeapYear(year)){
                daysBetween += 366;
            }else {
                daysBetween += 365;
            }
        }
        System.out.println("2000年1月1日到2008年1月1日相距的天数为：" + daysBetween);

        // 循环输入一个不为0的数进行累加，直到输入的数字为0，结束循环并最后输出累加的结果
        Scanner scanner = new Scanner(System.in);
        int input;
        int total = 0;
        do {
            System.out.print("请输入一个数字（输入0结束）：");
            input = scanner.nextInt();
            total += input;
        } while (input != 0);
        System.out.println("累加的结果为：" + total);
    }

    //判断闰年
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else return year % 400 == 0;
    }
}








