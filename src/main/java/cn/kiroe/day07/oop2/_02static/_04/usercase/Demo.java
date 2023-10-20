package cn.kiroe.day07.oop2._01game._02static._04.usercase;

/**
 * @author kiro
 * @description:
 * @data 15:08 19/10/2023
 **/
/*
创建一个学生类，用来描述我们班全体同学

要求：

属性：姓名，性别，年龄，学号，学校信息

行为：吃饭，学习

我们简单思考可以知道, 无论你是张三或者李四, 学校信息这个属性实质上应该是被全体同学所共有的属性，而不是独属于某个对象的, 这种场景下就可以使用static 修饰学校信息

举例2:

创建一个学生类,  有2个属性: 姓名String name , 学号int id

统计外部创建Student类对象的个数 假设给Student类的对象自动编号

这个编号第一次创建对象是10001 随后每创建一个新对象就+1
 */

/*
 <clinit> 栈帧 --》 加载中 初始化静态变量的栈帧
*/
public class Demo {

    public static void main(String[] args) {
        Student s1 = Student.getInstance("张三", true, 20);
        Student s2 = Student.getInstance("张四", true, 21);
        Student s3 = Student.getInstance("张五", true, 22);
        Student s4 = Student.getInstance("张刘", true, 23);
        System.out.println(s1.schoolInfo);
        System.out.println("s1.toString() = " + s1.toString());
        System.out.println("s2.toString() = " + s2.toString());
        System.out.println("s3.toString() = " + s3.toString());
        System.out.println("s4.toString() = " + s4.toString());
        System.out.println("Student.count = " + Student.count);


    }

}

/*

属性：姓名，性别，年龄，学号，学校信息

行为：吃饭，学习
 */

class Student{
    String name;
    boolean gender;
    int age;
    int id;
    // clinit 栈帧进行 静态负责操作
    static String schoolInfo = "北京大学";

    static int count = 0;

    private static int initId = 1001;
    public void eat(){
        System.out.println("吃饭");
    }

    public void study(){
        System.out.println("学习");
    }

    private Student(String name, boolean gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.id = Student.initId++;
        Student.count++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    //限制 对象的 创建：
    public static Student getInstance(String name, boolean gender, int age){
        if(Student.count < 3){
            return new  Student(name,gender,age);
        }
        return null ;
    }
}
