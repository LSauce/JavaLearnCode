package cn.kiroe.day12.oop._01intern._05annoymous._01basic;

interface IA {
    void m3();
}

/**
 * @author kiro
 * @description:
 * @data 16:46 26/10/2023
 **/

/*
匿名内部类
    1. 是一个特殊的 局部内部类
    2. 这个内部类没有名字
    3. 本质是个对象( 某个类 或者接口的子类对象)


new 类名或者接口名(){
	// 某类名或接口名的子类的类体
};

 */
public class Demo {

    public static void main(String[] args) {
        Father father = new Father();
        father.m1();
        // 匿名内部类
        // class Father2 extends Father
       /* Father father2 = new Father(){
            @Override
            public void m1() {
                super.m1();
            }
        };*/
        Father father1 = new Father() {
            @Override
            public void m1() {
                System.out.println("Father匿名内部类对象的m1()");
            }
        };
        father1.m1();



        new AbstractFather() {
            @Override
            void m2() {

            }
        };
        IA ia = new IA() {
            @Override
            public void m3() {

            }
        };


    }
}

class Father {

    public void m1() {
        System.out.println("this is father m1");
    }

}

abstract class AbstractFather {

    abstract void m2();
}