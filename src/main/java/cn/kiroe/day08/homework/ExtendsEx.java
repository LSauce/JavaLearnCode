package cn.kiroe.day08.homework;

/**
 * @author kiro
 * @description:
 * @data 19:58 20/10/2023
 **/
/*
继承基础语法练习
 提供以下两个动物需要描述，请用你的知识来编写代码
 猫：姓名，年龄，颜色，可以叫，可以抓老鼠
 狗：姓名，年龄，性别，可以叫，可以看门
 分析这个案例，设计出合适的继承体系。
 ​
 最后思考：人类研究出来了机器人，它们也有姓名，年龄，颜色等属性，可以套用本题中的继承体系吗？
 // 不适合，不符合 面向对象的思想
 */
public class ExtendsEx {
    public static void main(String[] args) {
        Cat cat  = new Cat("猫",10,"白色");
        Dog dog = new Dog("狗",50,"绿色");
        cat.shout();
        cat.catchingMice();
        dog.shout();
        dog.watchman();
    }
}
//动物
abstract class Animal{
    public String name;
    public int age;
    public String color;

    abstract public boolean shout() ;

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}
// 猫：姓名，年龄，颜色，可以叫，可以抓老鼠
class Cat extends Animal{


    public Cat(String name, int age, String color) {
        super(name, age, color);
    }

    public boolean shout(){
        if(super.age >0 && super.age <30) {
            System.out.println("喵叫了： 喵喵喵");
            return true;
        }else {
            System.out.println("喵叫不了，没出生或老死了");
            return false;

        }
    }
    public void catchingMice(){
        System.out.println("抓老鼠");
    }


}
// 狗：姓名，年龄，性别，可以叫，可以看门
class Dog extends Animal{
    public Dog(String name, int age, String color) {
        super(name, age, color);
    }
    @Override
    public boolean shout(){
        if(super.age >0 && super.age <30) {
            System.out.println("狗叫了： 汪汪汪");
            return true;
        }else {
            System.out.println("狗叫不了，没出生或老死了");
            return false;

        }
    }

    public void watchman(){
        System.out.println("看门中。。。");
    }
}


