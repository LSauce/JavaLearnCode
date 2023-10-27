package cn.kiroe.days12.oop._01intern._04local._04usercase;

/**
 * @author kiro
 * @description:
 * @data 16:33 26/10/2023
 **/
/*
**场景三：实现多继承**

1. 可以创建多个成员内部类继承外部多个类
一 ： 定义一个类 多实现接口
2. 然后创建内部类对象，实际上就是外部类继承了多个类的成员
 */
public class Demo {

    public static void main(String[] args) {

    }
}

interface IA{
    void m1();
}

interface IB{

    void m2();

}

interface IC{
    void m3();
}

class Son implements IA,IB,IC{

    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }
}

class A{
    public void m1() {

    }
}

class B{
    public void m2(){

    }
}

class C{
    public void m3(){

    }
}

class Son2{

    // 定义成员内部类
    // 分别继承别的类ABC
    class SonA extends A{
        @Override
        public void m1() {
            super.m1();
        }
    }
    class SonB extends B{
        @Override
        public void m2() {
            super.m2();
        }
    }
    class SonC extends C{
        @Override
        public void m3() {
            super.m3();
        }
    }

    public void test(){
        SonA sonA = new SonA();
        SonB sonB = new SonB();
        SonC sonC = new SonC();
        sonA.m1();
        sonB.m2();
        sonC.m3();
    }

}
