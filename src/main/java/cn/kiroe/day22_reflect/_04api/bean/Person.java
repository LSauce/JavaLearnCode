package cn.kiroe.day22_reflect._04api.bean;

/**
 * @author kiro
 * @description:
 * @data 17:18 7/11/2023
 **/
public class Person {
    public String name;
    private int age;
    boolean gender;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void eat() {
        System.out.println("eat....");
    }

    private void eat(String food) {
        System.out.println("eat..." + food);
    }


    public int sleep(){
        System.out.println("sleep");
        return 8;
    }

    public static  void test(){
        System.out.println("static Test");
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
