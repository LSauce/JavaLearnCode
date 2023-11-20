package cn.kiroe.day07.oop2._03anno;

/**
 * @author kiro
 * @description:
 * @data 16:06 19/10/2023
 **/

/*
匿名对象：
定义：
    没有名字的对象(没有引用接收的对象)
 */
public class Demo {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        //匿名对象
        new Student().study();
        new Student();
        new Student();
        new Student();

        // 让匿名对象作为方法的参数
        Demo.m1(new Student());
        m1(s1);
        m1(s2);

    }

    public static void m1(Student student) {
        System.out.println("student = " + student);
    }

    public static Student m2() {
        Student student = new Student();
        return student;
    }
}

class Student {
    public void study(){
        System.out.println("study");
    }
}
