package cn.kiroe.day10.oop._03interface._05default;

/**
 * @author kiro
 * @description:
 * @data 16:43 24/10/2023
 **/
public class Demo {
    public static void main(String[] args) {
        IA ia = new IAImpl();
        ia.m1();

        IA.staticM1();
    }
}

interface IA{
    //不是一个抽象方法
    default void m1(){
        System.out.println("这是个默认方法");
    }
    default void m2(){
        System.out.println("这是个默认方法");
    }

    // 还可以定义 静态方法
    static void staticM1(){
        System.out.println("static");
    }
}


class IAImpl implements IA{
    @Override
    public void m1() {
        System.out.println("impl111");
    }

    @Override
    public void m2() {
        System.out.println("impl222");
    }



}

