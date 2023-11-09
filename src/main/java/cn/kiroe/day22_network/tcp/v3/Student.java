package cn.kiroe.day22_network.tcp.v3;

import java.io.Serializable;

/**
 * @author kiro
 * @description:
 * @data 11:25 7/11/2023
 **/
public class Student  implements Serializable {
    private static final long serialVersionUID = 8074822438754020318L;
    private String name;
    private int age;

    public Student(String name, int age) {
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
