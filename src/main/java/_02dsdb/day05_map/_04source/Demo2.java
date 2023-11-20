package _02dsdb.day05_map._04source;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author kiro
 * @description:
 * @data 16:39 14/11/2023
 **/
public class Demo2 {
    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();
        Student student = new Student("ffff", 12);
        map.put(student,"123");
        student.name = "你好";
        System.out.println("map = " + map);
        map.remove(student); // 无法删除
        System.out.println("map = " + map);

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

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
