package cn.kiroe.day08._02access._01introduce.one;

/**
 * @author kiro
 * @description:
 * @data 11:03 20/10/2023
 **/
/*

权限修饰符：  private     protected   (default)    public
同类
同包
不同包子类
不同步其他类
 */
public class Demo {

    public int a = 1;
    int b = 1;
    private int c = 1;

    //静态成员变量
    public static int aa = 1;
    static int bb = 1;
    private static int cc = 1;

    public void m1() {

    }

    void m2() {

    }

    private void m3() {

    }

    public static void sm1() {

    }

    static void sm2() {

    }

    private static void sm3() {

    }

    public void test(){
        System.out.println("a = " + this.a);
        System.out.println("b = " + this.b);
        System.out.println("c = " + this.c);

        this.m1();
        this.m2();
        this.m3();
        System.out.println("Demo.aa = " + Demo.aa);
        System.out.println("Demo.bb = " + Demo.bb);
        System.out.println("Demo.cc = " + Demo.cc);
        Demo.sm1();
        Demo.sm2();
        Demo.sm3();
    }
}
