package cn.kiroe.day15_string.homework.ex7comparable;

/**
 * @author kiro
 * @description:
 * @data 20:00 30/10/2023
 **/
public class Cat implements Comparable<Cat>{

    int age;
    String name;
    double price;

    public Cat(int age, String name, double price) {
        this.age = age;
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Cat o) {
        return o.age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
