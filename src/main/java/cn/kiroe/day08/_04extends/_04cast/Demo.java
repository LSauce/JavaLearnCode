package cn.kiroe.day08._04extends._04cast;

/**
 * @author kiro
 * @description:
 * @data 16:18 20/10/2023
 **/
/*

引用的类型的  转换
// 为什么要了解 技术细节，
// 防止因为不了解 技术原理，导致 出现未预料bug，也更好的 理解 其他人的代码和原理
 */
public class Demo {
    public static void main(String[] args) {
        byte b= 1;
        //基本数据类型的 自动转换
        //由小范围 --> 大范围
        int a = b;
        //基本类型 强制类型转换
        // 大-->小
        int aa = 1;
        byte bb = (byte) aa; // 强制类型的转换

        // 引用数据类型的 类型转化
        Dog dog = new Dog();
        // Inconvertible types; cannot cast 'cn.kiroe.day08._04extends._04cast.Dog'
        // to 'cn.kiroe.day08._04extends._04cast.Cat'
        //Cat cat = (Cat) new Dog();

        // 发生类型转换的 前提条件 --》 继承

        // 明确一点  对象并没有改变 ，改变的是 引用的数据类型
        // 引用类型的 自动类型转化（向上转型）
        Animal dogAnimal = new Animal();
        // 等价于：
        Dog dog1 = new Dog();
        Animal dogAnimal1 = dog1;

        Animal catAnimal = new Cat();

        // 引用数据类型的 强制类型转换（向下转型）
        Animal animal1 = new Animal();
        //Cat cat2 = (Cat) animal1;
        // java.lang.ClassCastException
        Dog dog2 = (Dog) dogAnimal1;
    }
}
class Animal{

}
class Dog extends Animal{

}

class Cat extends Animal{

}
