package cn.kiroe.day09._01extends._05final._03variable._01local;

/**
 * @author kiro
 * @description:
 * @data 16:25 23/10/2023
 **/
/*

final 修饰变量 --> 常量
    变量：
        局部变量
        成员变量
        静态成员变量

final 局部变量
    1. 基本数据类型
        常量，值不能改变
    2. 引用数据类型
        引用的指向是不能变的

 */
public class Demo {
    public static void main(String[] args) {
        // 局部位置
        // 局部变量
        // final修饰 基本数据类型
        final int a = 1;
       // System.out.println("a = " + a++);//Cannot assign a value to final variable 'a'

        // final 修饰 引用数据类型：
        // 引用的指向不能改变
        final Student student = new Student("zs", 231);
        student.name = "ls";
        student.age = 23;
        System.out.println("student.age = " + student.age);
        System.out.println("student.name = " + student.name);
        // Cannot assign a value to final variable 'a'
        // student = new Student("ff",32);  指向不能改变

    }

    public static void test(final int a){

        System.out.println(a);
        // Cannot assign a value to final variable 'a'
        // a++;
    }
}


class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


}

