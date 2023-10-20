package cn.kiroe.day08._02access._01usecase;

/**
 * @author kiro
 * @description:
 * @data 11:33 20/10/2023
 **/
/*
单例设计模式：
    维护实例对象的方式，要求只能有一个对象

分类：
    1. 懒加载
        - 使用的时候才去加载
    2. 立即加载

如何实现单例：

 */
public class Singleton2 {
    // 立即加载  - 线程安全的
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {// new出来的 对象地址与 构造方法无关， 构造方法只用于 初始化
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

class SingletonDemo2 {

    public static void main(String[] args) {
        //Singleton singleton = new Singleton();
        Singleton singleton = Singleton.getInstance();
        System.out.println("singleton = " + singleton);
        System.out.println("Singleton.getInstance() = " + Singleton.getInstance());
    }

}
