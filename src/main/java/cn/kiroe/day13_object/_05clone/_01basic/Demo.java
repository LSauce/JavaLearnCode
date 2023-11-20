package cn.kiroe.day13_object._05clone._01basic;

/**
 * @author kiro
 * @description:
 * @data 17:13 27/10/2023
 **/
/*
源码
    protected native Object clone() throws CloneNotSupportedException;
    返回值类型： Object
     throws CloneNotSupportedException; 抛出一个不支持克隆异常
     (如果被clone的类没有实现Cloneable接口的话)

 */
public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student("zs", 23);
        System.out.println("s1 = " + s1);
        System.out.println("s1.clone() = " + s1.clone());


    }

}

class Student implements Cloneable{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
