package cn.kiroe.day13_object.homework.objecttest.test1;

import java.util.Objects;

/**
 * @author kiro
 * @description:
 * @data 19:59 27/10/2023
 **/
/*
equals方法语法编程练习题

定义一个Animal类
成员变量：
int age,String name,double price
手写它的equals方法，比较getClass和instanceof的区别

// getClass() 必须 类型完全 相同
// instanceof() 可为 子类
 */
public class Test {

    public static void main(String[] args) {
        Animal animal = new Animal(12, "猫", 12);
        Animal1 animal1 = new Animal1(14, "狗", 14);
        Dog dog = new Dog(12,"猫", 12);
        Cat cat = new Cat(14,"狗",14);

        System.out.println("animal.equals(dog) = " + animal.equals(dog));
        System.out.println("animal1.equals(cat) = " + animal1.equals(cat));
    }
}

class Animal{
    int age;
    String name;
    double price;

    public Animal(int age, String name, double price) {
        this.age = age;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Animal animal = (Animal) object;

        if (age != animal.age) return false;
        if (Double.compare(price, animal.price) != 0) return false;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

class Animal1{
    int age;
    String name;
    double price;

    public Animal1(int age, String name, double price) {
        this.age = age;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || ! (object instanceof Animal1)) return false;

        Animal1 animal = (Animal1) object;

        if (age != animal.age) return false;
        if (Double.compare(price, animal.price) != 0) return false;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

class Dog extends Animal{
    public Dog(int age, String name, double price) {
        super(age, name, price);
    }
}

class Cat extends Animal1{
    public Cat(int age, String name, double price) {
        super(age, name, price);
    }
}
