package cn.kiroe.day07.oop2._04block._03static._02classload;

/**
 * @author kiro
 * @description:
 * @data 17:19 19/10/2023
 **/
/*
类加载时机：
1. main方法
2. 首次new对象
3. 访问类的静态成员(成员变量,成员方法）
 */
public class Demo {

    //静态代码块
    static {
        System.out.println("Demo static block");
    }

    public static void main(String[] args) {
        System.out.println(111);

      /*  A a1 = new A();
        A a2 = new A();*/

        System.out.println("A.a = " + A.a);
        A.m1();


    }
}


class A{

    static int a= 1;
    static {
        System.out.println("A static block");
    }


    public static void m1(){
        System.out.println("A类中的m1");
    }

}
