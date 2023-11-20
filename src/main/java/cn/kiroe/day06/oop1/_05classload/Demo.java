package cn.kiroe.day06.oop1._05classload;

/**
 * @author kiro
 * @description:
 * @data 17:39 17/10/2023
 **/
public class Demo {
    public static void main(String[] args) {
        //类加载至 方法区中
        Student student =  new Student();
        student.age =10;
        student.name = "李四";
    }
}

class Student{
    String name;
    int age;
}
