package cn.kiroe.day09._01extends._02init._02classload;

/**
 * @author kiro
 * @description:
 * @data 10:21 23/10/2023
 **/

/*
类加载的时机：
    1.执行main前
    2.第一次new时
    3.使用静态成员时
    4.某个子类加载时（从继承类的祖先开始）
 */
public class Demo {

    public static void main(String[] args) {
        Son son = new Son();
    }
}

class GrandFather{
    static {
        System.out.println("gf static");
    }
}
class Father extends GrandFather{
    static {
        System.out.println("fa static");
    }
}
class Son extends Father{
    static {
        System.out.println("son static");
    }
    // 隐式子类对象初始化
    public Son() {
        // 默认这里有个 super(实参)
        // 手动写出来的 为 显示 对象初始化
        super();
        // 没写出来的，为隐时初始化
        System.out.println("eat songs");
    }
}
