package cn.kiroe.days13_object.homework.deepclone;

/**
 * @author kiro
 * @description:
 * @data 20:26 27/10/2023
 **/
/*
深度克隆练习
 分别定义以下类：
 教师类Teacher
 属性：int age;String name;Student stu
 学生类Student
 属性：int age；String name；Star s
 明星类Star
 属性：int age，String name
 ​
 尝试完成Teacher对象的深度克隆，并写代码进行测试
注：String虽然也是引用数据类型，但无需考虑对它的对象进行深度克隆。
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Star star = new Star("kk",12);
        Student student = new Student("ss",12,star);
        Teacher teacher = new Teacher("tt",30,student);
        System.out.println("teacher = " + teacher);
        System.out.println("teacher.clone() = " + teacher.clone());
    }
}
class Person implements Cloneable{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class Teacher extends Person{
    Student stu;

    public Teacher(String name, int age, Student stu) {
        super(name, age);
        this.stu = stu;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Teacher(this.name,this.age,(Student) stu.clone());
    }

    @Override
    public String toString() {
        return "Teacher{" + super.hashCode()+
                " stu=" + stu +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person{
    Star s;

    public Student(String name, int age, Star s) {
        super(name, age);
        this.s = s;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        return new Student(this.name,this.age, (Star) this.s.clone());
    }

    @Override
    public String toString() {
        return "Student{" + super.hashCode()+
                "s=" + s +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Star extends Person {
    public Star(String name, int age) {
        super(name, age);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Star{" +super.hashCode()+
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

