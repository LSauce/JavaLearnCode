package cn.kiroe.day06.oop1.homework.object.construct.exercise;

import org.junit.Test;

/**
 * @author kiro
 * @description:
 * @data 15:11 18/10/2023
 **/
public class StudentTest {
    /*
    定义一个Student类：

     成员变量：String name，int stuId，String gender，int age，double score（表示学生Java考试成绩）

      构造器：无参构造器，全参构造器等，自由发挥。

      成员方法：print()，打印对象所有属性的取值。

      类定义完毕后，创建五个Student对象存入Student对象数组中，完成以下两个操作：

1. 遍历输出每个学生的属性信息（遍历对象调用print()方法）
2. 求成绩平均值。

注：

1. 数组既可以存储基本数据类型（的值），也可以存储引用数据类型（的引用）。它们的使用没有本质区别。
2. 可以考虑提取方法实现功能，不要把所有代码一股脑写在main方法中。
     */
    @Test
    public void studentTest() {
        Student[] ss = new Student[6];
        // 初始化
        ss[0] = new Student("张三", 1, "大一", 10, 80);
        ss[1] = new Student("李四", 2, "大二", 10, 70);
        ss[2] = new Student("王五", 3, "大三", 10, 60);
        ss[3] = new Student("钟六", 4, "大四", 10, 30);
        ss[4] = new Student("刘七", 5, "大一", 10, 40);
        ss[5] = new Student("孙八", 6, "大二", 10, 50);

        // 1. 遍历输出每个学生的属性信息（遍历对象调用print()方法）
        for (Student s : ss) {
            s.println();
        }
        // 2. 求成绩平均值。
        double sum = 0;

        for (Student s : ss) {
            sum += s.getScore();
        }
        System.out.println("Java平均成绩为: "+ sum / ss.length );

    }
}
