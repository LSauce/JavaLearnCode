package cn.kiroe.day10.oop._02abstract._03.use;

/**
 * @author kiro
 * @description:
 * @data 14:50 24/10/2023
 **/

/*

**抽象类的使用，我们主要探讨，它的子类特点。**

抽象类的子类可以有两种情况：

1. 子类是普通类，普通类继承抽象类，必须实现所有的抽象方法。
2. 子类是抽象类，抽象子类不需要实现抽象方法，抽象子类可以自由选择实现（或实现或不实现）。

注：抽象类还可以继承一个普通类,
实际上如果一个抽象类, 它没有直接父类, 那它就直接继承Object

## 注意事项

1. abstract关键字，不能用来修饰构造器、属性、代码块等结构。
    只能修饰类或者方法。
2. abstract修饰类时，类的修饰符不能有final。
    因为抽象与 继承强相关
3. abstract修饰方法时，该方法不能有 除默认和public的 修饰符：
    因为抽象与 继承强相关
   1. private
   2. static
   3. final
4. 一个抽象类中可以没有抽象方法，但是没有意义
 */
public class Demo {
    public static void main(String[] args) {
        AbstractA a;
    }
}

abstract class AbstractA{
    public abstract void m1();
    public abstract void m2();
    public abstract void m3();
}
// Class 'A' must either be declared abstract or
// implement abstract method 'm1()' in 'AbstractA'
//子类是普通类，必须实现所有抽象方法
class A extends AbstractA{
    @Override
    public void m1() {
        System.out.println("to sth");
    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }
}

abstract class AbstractB{
    public abstract void m1();
}

// 子类是抽象类 按需实现
abstract class B extends AbstractB{
    @Override// 按需实现
    public void m1() {
        System.out.println("hahha");
    }
}
class C{
}

//抽象类 可以 继承 普通类
abstract class AbstractC extends C{
}


abstract class AbstractD{ // 抽象类中 可没有抽像类

}


