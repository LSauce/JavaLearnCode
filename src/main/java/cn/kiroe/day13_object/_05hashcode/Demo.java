package cn.kiroe.day13_object._05hashcode;

import java.util.Objects;

/**
 * @author kiro
 * @description:
 * @data 16:45 27/10/2023
 **/
/*

    public native int hashCode();

 */
public class Demo {
    public static void main(String[] args) {

        System.out.println("new Student(\"233\",12).hashCode() = " + new Student("233", 12).hashCode());
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
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

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
