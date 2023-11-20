package cn.kiroe.day10.oop._02abstract._01indtroduce;

/**
 * @author kiro
 * @description:
 * @data 11:52 24/10/2023
 **/

public class Demo {

    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.shout();

        //匿名内部类
        Animal animal1 = new Animal() {
            @Override
            public void shout() {
                System.out.println("你好");
            }
        } ;

        animal1.shout();

        Things things = () -> System.out.println("hello ");
        things.live();
    }
}
@FunctionalInterface //功能接口指的是，有且仅有一个必须要子类实现的抽象方法的接口。但可包扩Object中的方法
interface Things{
    public void live();

}
// abstract 修饰类 变为了 抽象类
abstract class Animal{
    public abstract void shout();
}

class Cat extends Animal{

    @Override
    public void shout() {
        System.out.println("cat");
    }
}

class Dog extends Animal{
    @Override
    public void shout() {
        System.out.println("dog");
    }
}