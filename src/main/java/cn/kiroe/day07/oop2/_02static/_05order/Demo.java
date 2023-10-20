package cn.kiroe.day07.oop2._02static._05order;

/**
 * @author kiro
 * @description:
 * @data 11:19 19/10/2023
 **/

/*
1.类加载过程 --> 静态成员赋值
2.对象建立过程 --》 非静态成员赋值


//顺序
// 先类加载： 静态初始化--》静态显示赋值 --》静态代码块
// new对象加载： 非静态初始化 --》 非静态显示赋值 --》非静态代码块 --》 构造方法赋值
 */
public class Demo {
    public static void main(String[] args) {
        new Dog("test");
    }
}

class Dog{
    static Cat cat =  new Cat("fff");
    String name = "fff";

    public Dog(String name) {
        this.name = name;
    }
}

class Cat{
    String name = "";
    static String spical = "ff";

    public Cat(String name) {
        this.name = name;
    }
}
