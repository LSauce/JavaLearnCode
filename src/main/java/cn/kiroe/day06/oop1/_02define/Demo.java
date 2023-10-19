package cn.kiroe.day06.oop1._02define;

/**
 * @author kiro
 * @description:
 * @data 16:11 17/10/2023
 **/
public class Demo {
    // 成员位置
    // 成员变量
    public static void main(String[] args) {

    }
    // 成员位置
    // 成员变量

    //成员方法： 没有static的方法
    public void memberMethod(){

    }

    //静态方法： 有static修饰的方法

}

class A {
    //类体
    public static void main(String[] args) {

        System.out.println(Student.a);

    }
}

class Student{
    static int a;
}
