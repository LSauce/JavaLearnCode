package cn.kiroe.day12.oop._01intern._01introduction;

/**
 * @author kiro
 * @description:
 * @data 10:14 26/10/2023
 **/

/*
在Java语言中类可以嵌套定义，广义的内部类指的是定义在另一类当中的一个类。

分类：
    根据定义位置：
    成员位置:
        成员内部类:
        静态内部类:
    局部位置：
        局部内部类：
        匿名内部类：
        Lambda表达式

学习方式:
   1.定义的位置
   2.权限修饰符
   3.成员特点
   4.继承和实现
   5.访问特点
       内部类----->外部类  全都能
       外部类----->内部类  需建立对象
       内部类----->外部其他类 建立对象即可
       外部其他类--->内部类 需建立外部类对象，再创建内部类对象
 */
public class Demo {
    // 外部其他类
    public static void main(String[] args) {

    }
}
// 外部类：
class Computer{
    private String resources;
    // 内部类
    private class CPU{
         int a = 10;
    }

    public static void main(String[] args) {

    }
}
