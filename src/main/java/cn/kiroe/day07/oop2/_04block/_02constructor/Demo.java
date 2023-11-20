package cn.kiroe.day07.oop2._04block._02constructor;

/**
 * @author kiro
 * @description:
 * @data 16:19 19/10/2023
 **/
/*
构造代码块：
    1.位置： 成员位置
    2.作用： 为成员变量赋值
 */
public class Demo {
    int a = 10000;//先默认初始化，再 显示赋值 ，后进行 构造代码块，最后 构造方法赋值
    String name = "fff";
    static int b= 100;
    //成员位置
    {
        //构造代码块
        a = 10;
        name = "";
    }

    static {
         b =1000;
    }

    public Demo(int a, String name) {
        this.a = a;
        this.name = name;
    }
}
