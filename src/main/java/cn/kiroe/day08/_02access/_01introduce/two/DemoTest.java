package cn.kiroe.day08._02access._01introduce.two;

import cn.kiroe.day08._02access._01introduce.one.Demo;

/**
 * @author kiro
 * @description:
 * @data 11:04 20/10/2023
 **/
public class DemoTest {

    public static void main(String[] args) {
        new Demo();

        Demo demo = new Demo();
        System.out.println("demo.a = " + demo.a);
        // 'b' is not public in 'cn.kiroe.day08._02access._01introduce.one.Demo'. Cannot be accessed from outside package
        // System.out.println("demo.b = " + demo.b);
        // 'c' has private access in 'cn.kiroe.day08._02access._01introduce.one.Demo'
        // System.out.println("demo.c = " + demo.c);



    }
}
