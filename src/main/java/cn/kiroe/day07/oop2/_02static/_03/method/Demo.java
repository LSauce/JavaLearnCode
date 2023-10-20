package cn.kiroe.day07.oop2._02static._03.method;

import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 14:46 19/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
        //Non-static method 'm1()' cannot be referenced from a static context
        //m1();
        //普通成员方法 是 基于对象的
        Demo demo = new Demo();
        demo.m1();
        //静态方法 可直接调用
        m2();
        //通过类名.方法名使用
        Demo.m2();

        //调用被的类的静态方法,必须注明类名
        //类名.方法名()
        Student.study();
        int[] arr = new int[]{1,2,3,4,5,-22};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println("Math.pow(2,4) = " + Math.pow(2, 4));


    }

    public static void m2() {

    }

    public void m1() {

    }
}

class Student{
    //静态成员方法
    public static void study(){

    }
}



