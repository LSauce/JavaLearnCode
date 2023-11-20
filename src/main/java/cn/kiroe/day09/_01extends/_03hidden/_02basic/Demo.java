package cn.kiroe.day09._01extends._03hidden._02basic;

/**
 * @author kiro
 * @description:
 * @data 14:34 23/10/2023
 **/
/*

属性隐藏
1. 访问范围（通过对象名. 出来的范围）
2. 访问结果(程序运行的结果)

结论：
    1.访问范围(编译的角度)：范围取决于 引用的数据类型（编译看左边）

    2.访问结果(运行的角度): 访问的结果 取决于 引用的数据类型(运行也看左)
    即 都为 引用类型决定的

静态变量 没有继承关系，所属为他们各自的类，但可通过 子类名 调用 父类  今天变量
 */
public class Demo {

    public static void main(String[] args) {
        //首先是 <font color=red>**对象名点访问成员变量**</font> ，对象的由来，可以有三种方式：

        // 1. 创建父类对象,用父类引用接收，用对象名点访问。
        // 范围： 父类中成员,
        // 访问结果: 父
        Father father = new Father();
        System.out.println("father.num = " + father.num);
        // 2. 创建子类对象,用子类引用接收，用对象名点访问。
        // 范围： 父类和子类中成员
        // 访问结果： 同名的为子，也可调用 父中不同名的
        Son son = new Son();
        System.out.println("son.num = " + son.num);
        // 3. 创建子类对象,用父类引用接收，用对象名点访问。*/
        // 范围： 父类中成员
        // 结果： 父类
        Father father1 = new Father();
        System.out.println("father1.num = " + father1.fatherNum);
        //可通过 子类.静态名访问, 但不是继承
        System.out.println("Son.st = " + Son.st);
    }


}

class Father{
    int num =0;
    int fatherNum = 2;
    static  int st =10;
}

class Son extends Father{
    int num =10;
    int sonNum = 20;
}
