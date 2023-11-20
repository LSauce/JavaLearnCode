package cn.kiroe.day07.oop2._04block._02constructor;

/**
 * @author kiro
 * @description:
 * @data 16:41 19/10/2023
 **/
public class Demo4 {
    public static void main(String[] args) {
        Dog d1 = new Dog("f",10);
        Dog d2 = new Dog("f");
        Dog d3 = new Dog();

        System.out.println(Dog.getCount());
    }
}

class Dog {


    String name;
    int age;
    private static int count;
     {
        count++;
    }


    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog() {
    }

    public static int getCount() {
        return count;
    }
}
