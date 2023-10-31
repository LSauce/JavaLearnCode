package cn.kiroe.days13_object._04equals._01basic;

import java.util.Objects;

/**
 * @author kiro
 * @description:
 * @data 16:06 27/10/2023
 **/

/*
public boolean equals(Object obj) {
        return (this == obj);
        // 比较当前对象和 参数对象是不是一个
        // 比较严格 只有当 对象为同一个时 要对象一样
    }
 */
public class Demo {

    public static void main(String[] args) {
        Student s1 = new Student("zs", 20);
        System.out.println("s1.equals(s1) = " + s1.equals(s1)); // true
        Student s2 = new Student("zs", 20);
        System.out.println("s1.equals(s2) = " + s1.equals(s1)); // false --》 变为true





    }
}

class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        // 自反性
        if (this == object) return true;
        // 排他性
        if (object == null || getClass() != object.getClass()) return false;
        // 成员变量取值相同
        Student student = (Student) object;

        if (age != student.age) return false;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
