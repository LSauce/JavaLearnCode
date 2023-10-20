package cn.kiroe.day07.homework.question8;

import org.junit.Test;

/**
 * @author kiro
 * @description:
 * @data 21:49 19/10/2023
 **/
/*
综合访问权限修饰符，static等知识点，做一个综合的练习。
 定义一个Student类，并要求在其他类中，最多只能创建10个Student类的对象。
     分析：
         1，如果允许外部直接创建对象，显然无法控制创建对象的个数
         2，需要计数器指示外部创建对象的个数

注意: 该题目具有一定综合性 如果一时想不明白 可最后做!
 */
public class Question5 {
    @Test
    public void Question5Test(){
        Student[] ss = new Student[12];
        for (int i = 0; i < 12; i++) {
            ss[i] = Student.getInstance("张"+i,i);
            System.out.println("ss["+i+"] = " + ss[i]);
        }

        System.out.println("Student.getInstance(\"t1\",1) = " + Student.getInstance("t1", 1));
    }
}
class Student{
    private static int instancesCount = 0;
    private String name;
    private int age;

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Student getInstance(String name,int age){
        if(instancesCount < 10){
            instancesCount++;
            return new Student(name,age);
        }

        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
