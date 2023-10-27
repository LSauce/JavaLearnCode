package cn.kiroe.day09._02polymorphic._2basic;

/**
 * @author kiro
 * @description:
 * @data 17:38 23/10/2023
 **/
/*

多态的访问特征
    1. 成员变量

    2. 成员方法
测试:
    1. 访问的范围
        成员变量 ：
    2. 访问的结果
 */
public class Demo {

    public static void main(String[] args) {
        // 父类引用 指向 父类对象
        Father father = new Father();
        // 访问成员变量, 运行编译 看左边
        System.out.println("father.fatherNum = " + father.fatherNum);
        System.out.println("father.num = " + father.num);
        // 访问成员方法,
        father.fatherMethod();
        father.func();

        // 子类引用 指向 子类对象
        Son son = new Son();
        System.out.println("son.fatherNum = " + son.fatherNum);
        System.out.println("son.num = " + son.num);
        // 方法的访问
        son.fatherMethod();
        son.sonMethod();
        son.func();

        //父类引用 指向 子类对象
        Father fs = new Son();

        //成员变量 开 左边
        System.out.println("fs.num = " + fs.num);
        System.out.println("fs.fatherNum = " + fs.fatherNum); //成员变量，看 引用类型
        //方法 编译看左边， 运行看右边
        fs.fatherMethod();
        fs.func();// 进行了方法的重写，可能 原理是 改变了 子类对象中，父类对象的方法
        // ((Son)fs).sonMethod();
    }
}

class Father{
    int num  =1;
    int fatherNum  =2;

    public void fatherMethod(){
        System.out.println("father");
    }

    public void func(){
        System.out.println("father func");
    }
}

class Son extends Father{
    int num = 10;
    int sonNum = 20;

    public void sonMethod(){
        System.out.println("son");
    }

    public void func(){
        System.out.println("son func");
    }
}
