package cn.kiroe.day09._01extends._02init;

/**
 * @author kiro
 * @description:
 * @data 10:12 23/10/2023
 **/
/*
1. 创建一个Person类，有name属性和eat方法
2. 创建一个Star类，有stageName属性和sing方法
3. Star类要继承Person类
4. 创建Star类对象，画出这个过程的内存图，描述子类对象初始化的过程
 */
public class Demo {

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println("son.a = " + son.a);
        System.out.println("son.b = " + son.b);
        System.out.println("----");

        Star star = new Star();
        System.out.println("star.name = " + star.name);
        System.out.println("star.stageName = " + star.stageName);
        star.eat();
        star.sing();
    }
}
class Person{
    static {
        System.out.println("person static ");
    }
    String name = "10";
    {
        name = "历史";
    }
    // 构造器
    public Person() {
        System.out.println("Person constructor");
    }

    public void eat(){
        System.out.println("eat");
    }

}
class Star extends Person{
    static {
        System.out.println("Star static");
    }
    {
        stageName = "ww";
    }
    String stageName =" kk";

    public Star() {
        System.out.println("star constructor");
    }

    public void sing(){
        System.out.println("sing");
    }
}

class Father{
    int a = 10;
}

class Son extends Father{
    int b = 20;
}
