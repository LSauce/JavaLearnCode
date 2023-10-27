package cn.kiroe.days12.oop._01intern._05annoymous._03ex;

/**
 * @author kiro
 * @description:
 * @data 17:41 26/10/2023
 **/

public class Demo{
    public static void main(String[] args) {
        Outer.method().show();
    }
}
@FunctionalInterface // 这只是建议。。
interface Inter {
    void show();
}
class Outer {
    public static Inter method(){
        return () -> System.out.println("哈哈");
    }
}
