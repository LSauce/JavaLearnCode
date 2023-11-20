package cn.kiroe.day13_object._03tostring;

import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 15:51 27/10/2023
 **/
/*

public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    返回值 String
    getClass.getName() 全限定类名
    Integer.toHexString(hashCode()); 10进制转为16进制
 */
public class Demo {

    public static void main(String[] args) {
        new Demo().toString();

        System.out.println(new Demo().hashCode());
        System.out.println(new Student("ss",99));

        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("zs"+i,23+i);
        }

        System.out.println(Arrays.toString(students) );
    }
}

class Student{
    String name;
    int age;

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
