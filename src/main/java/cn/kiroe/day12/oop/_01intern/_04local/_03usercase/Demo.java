package cn.kiroe.day12.oop._01intern._04local._03usercase;

interface IA {

}

/**
 * @author kiro
 * @description:
 * @data 16:05 26/10/2023
 **/

/*
局部内部类经常使用在以下两个场景中：

1. 方法需要返回一个对象，返回值类型是引用数据类型时。

   方法需要返回一个对象时，可以在方法的局部位置写一个 局部内部类 继承/实现外部的类/接口，创建对象后作为返回值。这是因为方法的返回值可以是返回值类型的对象，也可以是子类对象（当返回值类型是引用数据类型时）。

2. 方法需要传入一个对象，形参数据类型是引用数据类型时。

   方法需要传入一个对象实参时，可以在调用方法的位置定义一个 局部内部类 来继承/实现外部的类/接口，创建对象后作为方法的实参传入。这是因为方法的实参可以是形参类型的对象，也可以子类对象（当返回值类型是引用数据类型时）。

使用局部内部类的优点：

1. 绝对对外界隐藏，封装。
2. 相比较于传统的定义类，然后创建对象，它相对更加简洁省事。

缺点：

1. 这个类是一次性的。

综上，假如在局部位置需要一次性的使用某个对象，可以使用局部内部类创建它，但是如果多次在不同的方法中使用，使用局部内部类就得不偿失了。
 */
public class Demo {

    public static void main(String[] args) {

        m4(new Father());
        m4(new Son());
        class Son3 extends Father {

        }

        m4(new Son3());

        // 形参为抽象
        m5(new A());
        class SonAA extends AbstractA{}
        m5(new SonAA());
        // 形参为接口
        m6(new IAImpl());
        class IAAImpl3 implements IA{

        }
        m6(new IAAImpl3());

    }

    // 方法需要返回一个对象，返回值类型是引用数据类型时。
    public static Father m1() {
        class Son2 extends Father {

        }
        // return new Son();
        // 创建Son2对象， 创建局部内部类对象作为方法值

        return new Son2();
    }

    // 返回值是  抽象类
    public static AbstractA m2() {

        //return new A();

        // 局部内部类
        class SonA extends AbstractA {

        }

        return new SonA();

    }

    public static IA m3() {
        // return new IAImpl();

        class IAImpl2 implements IA {

        }

        return new IAImpl2();
    }

    // 形参是普通类型
    public static void m4(Father father) {

    }

    // 形参是抽象类型
    public static void m5(AbstractA abstractA) {

    }
    // 形参是接口类型
    public static void m6(IA ia){

    }


}

class Father {

}

class Son extends Father {

}

abstract class AbstractA {

}

class A extends AbstractA {

}

class IAImpl implements IA {

}
