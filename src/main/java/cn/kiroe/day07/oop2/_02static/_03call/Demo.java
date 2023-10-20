package cn.kiroe.day07.oop2._01game._03call;

/**
 * @author kiro
 * @description:
 * @data 11:06 19/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
        // 创建对象交换
        Student s1 = new Student("t1",11);
        Student s2 = new Student("t2", 22);
        swap(s1,s2);
        System.out.println(s1.getName());
        swap2(s1,s2);
        System.out.println(s1.getName());
    }

    private static void swap(Student s1, Student s2) {
        Student s3 = s1;
        s1 = s2;
        s2 = s1;
    }

    private static void swap2(Student s1, Student s2) {
        String name = s1.getName();
        s1.setName(s2.getName());
        s2.setName(name);
    }


}
