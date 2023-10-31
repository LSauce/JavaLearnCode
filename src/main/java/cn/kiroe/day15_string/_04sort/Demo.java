package cn.kiroe.day15_string._04sort;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

/**
 * @author kiro
 * @description:
 * @data 16:12 30/10/2023
 **/
public class Demo {
    public static void main(String[] args) {
        // 待排序的集合
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三1", 1, 100, 1));
        list.add(new Student("张三2", 2, 23, 66));
        list.add(new Student("张三3", 3, 43, 66));
        list.add(new Student("张三4", 4, 12, 77));
        list.add(new Student("张三5", 5, 4, 2));

        //Collections.sort(list, Demo::compare);
        Collections.sort(list);

        System.out.println("list = " + list);
        //list.sort(Demo::compare);

    }

    public static int compare(Student o1, Student o2) {
        // 优先级为 分数,年龄,id
        if (o1.score != o2.score) {
            return o1.score - o2.score;
        }
        if (o1.age != o2.age) {
            return o1.score - o2.score;
        }
        return o1.id - o2.id;
    }
}


class Student implements Comparable<Student> {

    String name;
    int id;
    int age;
    int score;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student(String name, int id, int age, int score) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", score=" + score +
                '}';
    }


    @Override
    public int compareTo(Student o2) {
        Student o1 = this;
        // 优先级为 分数,年龄,id
        if (o1.score != o2.score) {
            return o1.score - o2.score;
        }
        if (o1.age != o2.age) {
            return o1.score - o2.score;
        }
        return o1.id - o2.id;
    }
}
