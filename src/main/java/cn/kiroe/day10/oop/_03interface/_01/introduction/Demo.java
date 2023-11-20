package cn.kiroe.day10.oop._03interface._01.introduction;

/**
 * @author kiro
 * @description:
 * @data 15:18 24/10/2023
 **/
public class Demo {

    public static void main(String[] args) {

    }
}

interface Test{
    public static void main(String[] args) {
        System.out.println("test");
    }
}



abstract class Animal {
    public abstract void shout();
}
class Cat extends Animal {
    @Override
    public void shout() {
        System.out.println("猫叫");
    }
}
class Dog extends Animal {
    @Override
    public void shout() {
        System.out.println("狗叫");
    }
}

//特殊的喵
class SuperCat extends Cat implements Skill{
    public void walk(){
        System.out.println("会直立行走");
    }
}

class SuperDog extends Dog implements Skill{
    public void walk(){
        System.out.println("会直立行走");
    }
}// 没有代码的复用
//Java 没有多继承
// 不能继承多个类
interface Skill{

     void walk();
}

class Tiger implements Skill {


    @Override
    public void walk() {
        System.out.println("老虎会走");
    }
}
