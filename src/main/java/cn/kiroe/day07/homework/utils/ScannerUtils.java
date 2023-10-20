package cn.kiroe.day07.homework.utils;

import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 21:41 19/10/2023
 **/

/*

工具类不需要创建对象，应该私有化构造方法
定义一个Scanner工具类ScannerUtils，提供以下方法：
     1，先给出友好提示，然后利用Scanner键盘录入字符串，返回这个字符串。
     2，先给出友好提示，然后利用Scanner键盘录入int整数，返回这个整数。
     3，给出友好提示，键盘录入一个Person对象，返回这个对象。（Person类中有age和name属性）
注：录入对象，无非就是先录入成员变量取值，然后再用构造器创建对象。

这里需要在Scanner对象实现键盘录入功能的基础上,封装一层,完成更友好的键盘录入

思考以下问题:

三个方法都需要用Scanner对象，那么有必要创建三个Scanner对象吗？如果不需要，那么这个Scanner对象如何定义呢？
 */
public class ScannerUtils {

    private ScannerUtils() {
    }

    private final static Scanner sc = new Scanner(System.in);

     //1，先给出友好提示，然后利用Scanner键盘录入字符串，返回这个字符串。
     public static String getInputString(){
         System.out.println("---获取输入字符串---");
         System.out.println("请输入字符串：");
         return sc.nextLine();
     }
     //2，先给出友好提示，然后利用Scanner键盘录入int整数，返回这个整数。
     public static int getInputInt(){
         System.out.println("---获取输入整数---");
         System.out.println("请输入整数：");
         return sc.nextInt();
     }
    /*
     3，给出友好提示，键盘录入一个Person对象，返回这个对象。（Person类中有age和name属性）
     */
    public static Person getInputPerson(){
        System.out.println("---获取输入整数---");
        System.out.println("请输入姓名 年龄：");
        String name = sc.next();
        int age= sc.nextInt();
        return new Person(name,age);
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Test{
    public static void main(String[] args) {
        System.out.println("ScannerUtils.getInputString() = " + ScannerUtils.getInputString());
        System.out.println("ScannerUtils.getInputInt() = " + ScannerUtils.getInputInt());
        System.out.println("ScannerUtils.getInputPerson() = " + ScannerUtils.getInputPerson());
    }
}
