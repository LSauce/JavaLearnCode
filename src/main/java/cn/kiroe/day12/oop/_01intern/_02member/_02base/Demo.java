package cn.kiroe.day12.oop._01intern._02member._02base;

/**
 * @author kiro
 * @description:
 * @data 10:29 26/10/2023
 **/

/*
学习方式:
   1.定义的位置
       成员位置
   2.权限修饰符
        能用全部四种, public、 protected、默认、private
   3.成员特点
        jdk8不能有静态说明, jdk16后可以
   4.继承和实现
        可以继承和实现外部的 类和接口
   5.访问特点： 把成员内部类 当成 外部类的成员
       内部类----->外部类 不受权限控制
            全都能范围,当同名，就近原则，访问内部
            局部变量同名
            直接访问 --> 局部变量
            通过this. --> 内部类同名成员
            通过Outer.this --> 外部内的成员


       外部类----->内部类  需建立对象，不受权限控制
            成员方法：
                创建内部类对象，通过对象. 方式访问
            静态成员方法：
                创建外部类对象，在创建内部类对象，通过对象. 访问
                // 通过 内部类对象，访问
                Outer outer = new Outer();
                Inner inner = outer.new Inner();
                // 等价于
                Inner inner1 = new Outer().new Inner();
       内部类----->外部其他类  建立对象即可
       外部其他类--->内部类 需建立外部类对象，再创建内部类对象，有权限限制
 */
public class Demo {
    int a = 1;
    private int b =2;
    static int c =3;

    public static void main(String[] args) {

        // 外部类 访问--> 内部类
        // 创建外部类对象

        Outer.Inner inner = new Outer().new Inner();
        System.out.println("inner.aa = " + inner.aa);
        //System.out.println("inner.bb = " + inner.bb); 有权限控制
        System.out.println("inner.d = " + inner.d);

    }
}

// 外部类：
class Outer{
    // 成员变量
    int a =1;
    static int b = 2;
    private int c = 3;
    //同名
    int d = 4;

    // 成员方法
    public void outerNormalMethod(){
        // 外部类 --> 内部类
        // 需要对象，不能直接访问
       // System.out.println(aa);
        // 通过对象. 访问
        Inner inner = new Inner();
        System.out.println("inner.aa = " + inner.aa);
        System.out.println("inner.bb = " + inner.bb);// 内部不用看 权限，无意义

    }
    public void outerNormalMethod2(){
       // new Inner().innerMethod1();
    }
    // 静态成员方法
    public static void outerStaticMethod(){
        // Outer.this' cannot be referenced from a static context
        //Inner inner = new Inner();
        // 创建外部对象 再去创建内部类对象
        // 通过 内部类对象，访问
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        // 等价于
        Inner inner1 = new Outer().new Inner();
        System.out.println("inner.aa = " + inner.aa);
        System.out.println("inner.bb = " + inner.bb);
        inner.innerMethod1();
    }

    public static void outerStaticMethod2(){

    }
    // 成员内部类
    public class Inner{
        int aa = 10;
        private int bb = 20;
        int d = 40;

        public void innerMethod1(){

            int d = 400;
            // 内部类访问 外部类
            System.out.println("a = " + a);
            System.out.println("b = " + Outer.b);
            System.out.println("c = " + c);
            // 就近原则，同名访问的为 内部的
            System.out.println("d = " + d);// 就近原则
            // 可通过外部this访问
            System.out.println("Outer.this.d = " + Outer.this.d);
            System.out.println("this.d = " + this.d);// 内部成员
            // 方法的访问
            outerNormalMethod();
            Outer.outerStaticMethod();
        }
        public void innerMethod2(){
            //由内访问外部其他
            // 创建对象
            Demo demo = new Demo();
            System.out.println("demo.a = " + demo.a);
            // System.out.println(demo.b); 私有访问
            System.out.println("Demo.c = " + Demo.c);

        }


    }


}