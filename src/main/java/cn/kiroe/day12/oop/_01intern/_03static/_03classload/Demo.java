package cn.kiroe.day12.oop._01intern._03static._03classload;

/**
 * @author kiro
 * @description:
 * @data 15:07 26/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
        // 创建外部对象 --》 只加载了外部类
        //  Outer outer = new Outer();
        //  创建内部类对象 --》 只加载了 内部类 ,外部类没有加载
        // 静态内部类是 个独立的类
        Outer.Inner inner = new  Outer.Inner(); //
        //Outer.Inner inner = new Outer().new Inner(); //
    }
}

class Outer{
    static {
        System.out.println("outer static block");
    }

     static class Inner{
       {
            System.out.println("inner static block");
        }
    }
}
