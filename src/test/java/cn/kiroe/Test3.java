package cn.kiroe;

/**
 * @author kiro
 * @description:
 * @data 20:16 18/10/2023
 **/
public class Test3 {

    public static void main(String[] args) {
        System.out.println("test");
        new Student("233");
    }

}


class Student{
    String name = "张三";

    public Student(String name) {
        this.name = name;
    }
}

