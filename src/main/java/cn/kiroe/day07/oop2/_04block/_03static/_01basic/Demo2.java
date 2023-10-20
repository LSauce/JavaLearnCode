package cn.kiroe.day07.oop2._04block._03static._01basic;

/**
 * @author kiro
 * @description:
 * @data 17:10 19/10/2023
 **/

/*
1. 默认初始化
2. 显示赋值
3. 静态代码赋值
测试
    1.
 */
public class Demo2 {


    public static void main(String[] args) {
        Dog dog = new Dog("dog");
    }
}

class Dog{
    String name;
    static {
        age = 11;
    }
    static  int age = 10;

    public Dog(String name) {
        this.name = name;
    }


}
