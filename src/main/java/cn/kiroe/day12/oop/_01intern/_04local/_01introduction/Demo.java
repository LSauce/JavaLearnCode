package cn.kiroe.day12.oop._01intern._04local._01introduction;

/**
 * @author kiro
 * @description:
 * @data 15:15 26/10/2023
 **/
/*

   1.定义的位置
        局部位置
   2.权限修饰符
        局部位置不能加 权限符
   3.成员特点
        和成员内部类一致 ,不能有静态声明
   4.继承和实现

   5.访问特点
        理解： 局部内部类 在作用域生效
       内部类----->外部类
            直接访问,无权限限制
       外部类----->内部类
            需要new对象，
       内部类----->外部其他类
       外部其他类--->内部类
 */
public class Demo {
}

class Outer{

    //成员位置
    public void outerNormalMethod(){
        // 局部位置
        // 局部内部类 Modifier 'private' not allowed here
        int a =0;

        class Inner1{

            private int b= 0;
            //static int c= 2;  不能有静态声明
            //public static void saticM1();

        }

        class Inner2 extends A implements IA {

        }
    }

    public static void outerStaticMethod() {
        // 局部位置
        class Inner1{

        }

        class Inner2{

        }
    }
}


class A{
}

interface IA{

}
