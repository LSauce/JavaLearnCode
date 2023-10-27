package cn.kiroe.days12.oop._01intern._04local._02basic;

/**
 * @author kiro
 * @description:
 * @data 15:24 26/10/2023
 **/
/*
5.访问特点
        理解： 局部内部类 在作用域生效
       内部类----->外部类
            直接访问,无权限限制
            静态局部中,需要new对象，但无权限限制
            同名 Outer.this.
       外部类----->内部类
            在局部范围，需要new对象，外的的无法访问
       内部类----->外部其他类
             直接new,和普通类一样
       外部其他类--->内部类
             无法访问
 */
public class Demo {
    int aaa = 1;
    private int bb =2;
    static int ccc = 3;
    public static void main(String[] args) {

    }
}

class Outer{
    // 外部类成员
    int a = 1;
    private int b =2;
    static int c = 3;
    int d = 4;
    // 外部类的普通方法
    public void outerNormalMethod(){
        
        // 局部位置
        class Inner{
            // 局部内部类成员
            int aa = 10;
            private int b = 20;
            int d = 40;

            public void innerMethod1(){
                // 由内向外
                System.out.println(Outer.this.a);
                System.out.println(b);
                System.out.println(Outer.c);
                //定义一个 局部变量
                int d = 400;
                // 直接访问
                System.out.println("d = " + d);
                //通过  Outer.this.d 调用
                System.out.println("Outer.this.d = " + Outer.this.d);
                // 内部类中内部类
                class Test{
                    public void test(){
                        System.out.println("Outer.this.a = " + Outer.this.a);
                        System.out.println(Inner.this.aa);
                    }
                }

                // 方法的调用
                outerStaticMethod();
                Outer.outerStaticMethod();

            }
            public void innerMethod2(){
                // 创建外部对象 ,通过对象. 方式是访问
                Demo demo = new Demo();
                System.out.println("demo.aaa = " + demo.aaa);

            }
        }
        
        // 外访问内部类, 通过对象访问
        Inner inner = new Inner();
        System.out.println("inner.aa = " + inner.aa);
        System.out.println("inner.b = " + inner.b);
        System.out.println("inner.b = " + inner.d);
        //
        inner.innerMethod1();


    }

    public void outerNormalMethod2(){
        // Inner inner = new Inner();

    }
    // 外部类的静态方法
    public static void outerStaticMethod(){


        class Inner{

            public void innerNormalMethod(){
                //System.out.println(a); // 静态方法中的 内部类,需要 new对象
            }
        }

        // 创建inner对象
        Inner inner = new Inner();
        inner.innerNormalMethod();
    }

}
