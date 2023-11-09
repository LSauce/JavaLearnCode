package _02dsdb.day01_generic._08extends;

import org.junit.Test;

/**
 * @author kiro
 * @description:
 * @data 17:53 9/11/2023
 **/
public class Demo1 {

    public static void main(String[] args) {
    }

    @Test
    public void test1(){

        // 协变 是 允许接受该类及该类的子类
        // 数组是允许协变的
        Animal[] animals = new Cat[10];
        // 泛型是不允许协变的
        User<Animal> animalUser = new User<>();
        // animalUser = new User<Cat>();

    }

    @Test
    public void test2(){
        // 泛型想完成协变的功能,
        // 会有类型不匹配问题
        Animal[] animals = new Cat[10];

        animals[0] = new Cat();
        animals[0] = new Cat();
        animals[0] = new Cat();
        // java.lang.ArrayStoreException
        animals[1] = new Dog(); // 编译时 没保存，运行时保存
    }

    @Test
    public void test3(){
        // 逆变就是，允许接收该类及该类的父类。
    }
}
class User<T>{

}
class Animal{

}

class Cat extends Animal{

}

class Dog extends Animal{

}
