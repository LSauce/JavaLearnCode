package cn.kiroe.day09._01extends._03hidden;

/**
 * @author kiro
 * @description:
 * @data 11:53 23/10/2023
 **/

// 属性的隐藏
/*
访问的范围

*/
public class Demo {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.a);
        System.out.println(son.getA());
        /*
        首先是 <font color=red>**对象名点访问成员变量**</font> ，对象的由来，可以有三种方式：

2. 创建子类对象,用子类引用接收，用对象名点访问。
3. 创建子类对象,用父类引用接收，用对象名点访问。
         */
        //1. 创建父类对象,用父类引用接收，用对象名点访问。

    }
}

class Father{
    int a = 880;


    public int getA() {
        return a;
    }
}

class Son extends Father{
    int a = 21;
}


