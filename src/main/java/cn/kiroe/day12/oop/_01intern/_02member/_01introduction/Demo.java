package cn.kiroe.day12.oop._01intern._02member._01introduction;

/**
 * @author kiro
 * @description:
 * @data 10:22 26/10/2023
 **/

/*

分类：
    根据定义位置：
    成员位置:
        成员内部类:
        静态内部类:
    局部位置：
        局部内部类：
        匿名内部类：
        Lambda表达式

学习方式:
   1.定义的位置
       成员位置
   2.权限修饰符
        能用全部四种, public、 protected、默认、private
   3.成员特点
        jdk8不能有静态说明, jdk16后可以
   4.继承和实现
        可以继承和实现外部的 类和接口
   5.访问特点
       内部类----->外部类  全都能
       外部类----->内部类  需建立对象
       内部类----->外部其他类 建立对象即可
       外部其他类--->内部类 需建立外部类对象，再创建内部类对象
 */
public class Demo {


}

class Outer{
    int c= 10;
    //成员位置
    private class Inner1{
        int a = 1;

        void innerMethod(){
            c = 100;
        }
        //Static declarations in inner classes are not supported at language level '8'
        // static int b = 1; //不能加静态成员 , jdk16后可加
        // Static declarations in inner classes are not supported at language level '8
        //static void innerStaticMethod(){
       // }
    }

    class Inner2 extends A implements IA{
        @Override
        public void m1() {

        }
    }

}

class A{

}

interface IA{
    public void m1();
}
