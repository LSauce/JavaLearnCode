package cn.kiroe.day08._02access._01introduce.one;

/**
 * @author kiro
 * @description:
 * @data 11:04 20/10/2023
 **/
public class DemoTest {

    public static void main(String[] args) {
        Demo demo = new Demo();

        //成员变量测试
        System.out.println("demo.a = " + demo.a);
        System.out.println("demo.b = " + demo.b);
        // 'c' has private access in 'cn.kiroe.day08._02access._01introduce.one.Demo'
        //System.out.println("demo.c = " + demo.c);
        //方法测试
        demo.m1();
        demo.m2();
        // 'm3()' has private access in 'cn.kiroe.day08._02access._01introduce.one.Demo'
        //demo.m3();

        // 静态成员的测试
        System.out.println("Demo.aa = " + Demo.aa);
        System.out.println("Demo.aa = " + Demo.aa);
        // 'cc' has private access in 'cn.kiroe.day08._02access._01introduce.one.Demo'
        //System.out.println("Demo.aa = " + Demo.cc);

        Demo.sm1();
        Demo.sm2();
        // 'sm3()' has private access in 'cn.kiroe.day08._02access._01introduce.one.Demo'
        //Demo.sm3();

    }
}
