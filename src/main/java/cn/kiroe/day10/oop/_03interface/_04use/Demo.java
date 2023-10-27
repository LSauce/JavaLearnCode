package cn.kiroe.day10.oop._03interface._04use;

/**
 * @author kiro
 * @description:
 * @data 16:26 24/10/2023
 **/

/*
**注意两个问题:**

1. 实现接口的类，如果没有明确继承一个其他类，那么子类对象的隐式初始化super()指向Object类。
2. 接口虽然不是类，但是它也继承了Object类。



**接口的使用，我们主要探讨它的子类特点。**

接口的子类可以是什么？

1. 普通类实现接口，必须实现所有的抽象方法。

2. 抽象类实现接口，按需实现抽象方法。

3. 接口可以继承一个接口，并且接口在继承接口后，可以重写父接口中的抽象方法和默认方法。

   参考如下代码（了解即可）：
 */
public class Demo {
    public static void main(String[] args) {
        SonA sonA = new SonA();
        sonA.m1();
        sonA.m2();;
    }
}

interface IA{
    void m1();

    void m2();
}
//1. 普通类实现接口，必须实现所有的抽象方法。
//Class 'A' must either be declared abstract or
// implement abstract method 'm1()' in 'IA'
class A implements IA{

    @Override
    public void m1() {
        //do sth
    }

    @Override
    public void m2() {
        //do sth
    }
}

// 2. 抽象类实现接口，按需实现抽象方法。
abstract class AbstractA implements IA{

    @Override
    public void m1() {
        System.out.println("AbstractA");
    }
}
interface IC{

}

interface ID{

}

//3. 接口可以继承(extends)一个接口，并且接口在继承接口后，可以重写父接口中的抽象方法和默认方法。
interface IB extends IA,IC,ID{ // 接口的继承是 多继承

    @Override
    void m2();
}


class SonA extends A{
    //do sth
}
