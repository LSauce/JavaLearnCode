package cn.kiroe.day09._01extends._02init._03super._02user;

/**
 * @author kiro
 * @description:
 * @data 11:28 23/10/2023
 **/
/*
super 的使用
通过super 区分父类和 子类的 同名方法和变量

    作用:
        super(实参) 父类构造器
        super.成员 同名调用父类成员
super 不是 一个引用 ， 父类对象，储存在 子类对象中
super有 权限符 的 限制
 */
public class Demo {
    public static void main(String[] args) {
        Son son = new Son();
        son.m1();

        int a = 10;
        int b = 5;
        int c = a = b;
        System.out.println(a+""+b+c);
    }
}
class Father{
    int a = 1;
}

class Son extends Father{
    int a = 10;

    public void m1(){
        System.out.println(this);
        //System.out.println("super = " + super); super不是一个引用
    }
}
