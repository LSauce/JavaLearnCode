package cn.kiroe.day07.oop2._04block._04ex;

/**
 * @author kiro
 * @description:
 * @data 17:44 19/10/2023
 **/
public class Demo {
    static {
        System.out.println("Demo类开始初始化步骤了!");
    }
//
    static Cat cat = new Cat();
    Dog dog = new Dog();

    public static void main(String[] args) {
        System.out.println("hello world!");
        Demo d = new Demo();
    }

    public Demo() {
        System.out.println("demo");
    }
}

class Cat {
    static {
        System.out.println("Cat类开始初始化步骤了!");
    }

    static Dog dog = new Dog();

    public Cat() {
        System.out.println("cat");
    }
}

class Dog {
    static {
        System.out.println("Dog类开始初始化步骤了!");
    }

    static Demo demo = new Demo();

    public Dog() {
        System.out.println("dog");
    }
}


