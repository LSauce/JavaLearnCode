package cn.kiroe.day09.homework.finaltest;

/**
 * @author kiro
 * @description:
 * @data 19:49 23/10/2023
 **/
/*
final修饰成员/静态成员变量，表示一个常量，必须明确地赋值。
自定义一个类，类中定义三个成员变量a，b，c，用final修饰这三个成员变量
再定义两个静态成员变量staticA和staticB，也用final修饰这两个静态成员变量
然后：
    1，请用三种不同的方式，分别为成员变量a，b，c赋值
    2，请用两种不同的方式，分别为静态成员变量staticA和staticB赋值
 */
public class FinalTest {

    public static void main(String[] args) {

    }
}

class finalDemo{
    /*
    自定义一个类，类中定义三个成员变量a，b，c，用final修饰这三个成员变量
再定义两个静态成员变量staticA和staticB，也用final修饰这两个静态成员变量
     */
    final int a = 111; // ①显式赋值
    final int b;
    final int c;

    final static int staticA = 100;// 2.① 显示赋值
    final static int staticB;

    //  1，请用三种不同的方式，分别为成员变量a，b，c赋值
    //    2，请用两种不同的方式，分别为静态成员变量staticA和staticB赋值
    {
        b = 222; // ②构造代码块赋值
    }

    static {
        staticB = 200;// 2.② 静态代码块赋值
    }

    //③构造方法赋值
    public finalDemo(int c) {
        this.c = c;
    }
}
