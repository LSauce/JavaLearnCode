package cn.kiroe.day06.oop1.homework.object.construct.exercise;

/**
 * @author kiro
 * @description:
 * @data 15:12 18/10/2023
 **/
public class Student {
    /*
    成员变量：String name，int stuId，String gender，int age，double score（表示学生Java考试成绩）

    构造器：无参构造器，全参构造器等，自由发挥。
    成员方法：print()，打印对象所有属性的取值。
     */

    private String name;
    private int stuId;
    private String gender;
    private int age;
    private double score;

    public Student(String name, int stuId) {
        this.name = name;
        this.stuId = stuId;
    }

    public Student(String name, int stuId, String gender, int age, double score) {
        this.name = name;
        this.stuId = stuId;
        this.gender = gender;
        this.age = age;
        this.score = score;
    }

    public void println(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", stuId=" + stuId +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getStuId() {
        return stuId;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }
}
