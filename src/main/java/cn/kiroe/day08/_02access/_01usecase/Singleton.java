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
public class Singleton {
    // 懒加载 - 线程不安全的
    private static Singleton instance;

    private Singleton() {// new出来的 对象地址与 构造方法无关， 构造方法只用于 初始化
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}

class SingletonDemo {

    public static void main(String[] args) {
        //Singleton singleton = new Singleton();
        /*Singleton singleton = Singleton.getInstance();
        System.out.println("singleton = " + singleton);
        System.out.println("Singleton.getInstance() = " + Singleton.getInstance());*/

        new Thread(() -> {
            Singleton singleton2 = Singleton.getInstance();
            System.out.println("singleton2 = " + singleton2);
        }).start();

        new Thread(() -> {
            Singleton singleton2 = Singleton.getInstance();
            System.out.println("singleton2 = " + singleton2);
        }).start();


    }

}
