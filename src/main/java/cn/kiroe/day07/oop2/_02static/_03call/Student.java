package cn.kiroe.day07.oop2._01game._03call;

/**
 * @author kiro
 * @description:
 * @data 11:06 19/10/2023
 **/
public class Student {
    private String  name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
