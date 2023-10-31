package cn.kiroe.days13_object._01introduction;

import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 14:53 27/10/2023
 **/

/*

源码：
    public final native Class<?> getClass();
    final 不能重写
    native 本地方法
    Class 方法的返回值
    getClass 方法名

 */
public class Demo {
    public static void main(String[] args) {
        //m1();//

        Student s1 = new Student("zs", 20);
        Student s2 = new Student("zs", 20);
        Class<? extends Student> c1 = s1.getClass();
        Class<? extends Student> c2 = s2.getClass();
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        // 通过
        System.out.println("c1.getName() = " + c1.getName());
        System.out.println("c1.getSimpleName() = " + c1.getSimpleName());
        System.out.println("c1.getSuperclass() = " + c1.getSuperclass());
        // 获取实现的接口
        System.out.println("c1.getInterfaces() = " + Arrays.toString(c1.getInterfaces()) );

        System.out.println("Arrays.toString( c1.getFields()) = " + Arrays.toString(c1.getDeclaredFields()));
        // 获取所有的构造器
        System.out.println("Arrays.toString(c1.getDeclaredConstructors()) = " + Arrays.toString(c1.getDeclaredConstructors()));
        //
    }

    @Deprecated // 过期 不推荐使用
    public static void m1(){

    }
}

class Student implements IA{
    String name;
    int age;

    public Student(String name, int age){
        this.name = name;
        this.age  = age;
    }

    public void study(){
        System.out.println("study");
    }
}

interface IA{

}

