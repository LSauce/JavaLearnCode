package cn.kiroe.day09._01extends._05final._03variable._03static;

/**
 * @author kiro
 * @description:
 * @data 16:48 23/10/2023
 **/

/*
final 修饰静态全局变量  --> 全局常量
// [访问权限修饰符] static final 数据类型 变量名;
final 修饰静态成员变量的 时候， 必须初始化(不能使用默认初始化)
    赋值手段：
        1. 显示赋值
        2. 静态代码块
 */
public class Demo {

    public static void main(String[] args) {
        Student student1 = new Student("张三");
        Student student2 = new Student("张三1");
        Student student3 = new Student("张三2");
        Student student4 = new Student("张三3");

        System.out.println(Student.schoolInfo);
        System.out.println(Student.classInfo);

        System.out.println(student1.name);
        System.out.println(student2.name);
        System.out.println(student3.name);
        System.out.println(student4.name);

    }
}

class Student{
    final static String schoolInfo;
    // static final String schoolInfo //和上面效果一样
    final static String classInfo = "Java55期";
    static {
        schoolInfo = "王道";
       // classInfo = "Java55" 只能选择一种赋值
    }


    String name;

    public Student(String name) {
        this.name = name;
    }
}


