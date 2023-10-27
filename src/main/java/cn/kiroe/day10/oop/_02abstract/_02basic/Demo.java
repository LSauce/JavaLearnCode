package cn.kiroe.day10.oop._02abstract._02basic;

import sun.reflect.generics.tree.VoidDescriptor;

/**
 * @author kiro
 * @description:
 * @data 14:44 24/10/2023
 **/
/*
**特点**

抽象类的特点我们主要从以下角度：

1. 类名命名特点是什么?
2. 能用哪些修饰符？
3. 成员特点
   1. 普通成员  --ok
   2. 静态成员  --ok
   3. 抽象方法  --ok
4. 构造器 -->ok
5. 代码块 -->ok
总结： 抽象类 就是在普通类中 加了个 抽象方法
 */
public class Demo {

}
abstract class AbstractPerson{
    //3. 成员特点
    //   1. 普通成员  --ok
    int a = 10;
    void test(){
        System.out.println("Test");
    }
    //   2. 静态成员  --ok
    static int staticB = 20;
    static void tset2(){
        System.out.println(2);
    }
    //   3. 抽象方法  --ok
    abstract void test3(); // 抽象类不能有 方法体
    //abstract static void test4(); //static无继承不能static//Illegal combination of modifiers: 'abstract' and 'static'
    //4. 构造器 -->ok
    //用于初始化
    //5. 代码块 -->ok
    // 用于初始化
}


