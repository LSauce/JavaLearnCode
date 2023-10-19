package cn.kiroe.day06.oop1._08constructor;

/**
 * @author kiro
 * @description:
 * @data 11:51 18/10/2023
 **/


public class Demo2{
    public static void main(String[] args){
        Student2 stu = new Student2(18,"王冰冰");
    }
}
class Student2 {
    int age = 10;
    String name = "张三";
    double a = 100;

    public Student2(int age) {
        System.out.println("Student age");
        this.age = age;
    }

    public Student2() {

    }

    public Student2(int age, String name) {
        this(age);
        System.out.println("Student age，name");
        this.name = name;
    }
}
