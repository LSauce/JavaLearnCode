package cn.kiroe.days12.oop._01intern._04local._03usercase;

import java.security.PublicKey;

/**
 * @author kiro
 * @description:
 * @data 16:20 26/10/2023
 **/
/*

### 注意事项

一. 在局部内部类的成员方法中，如果想要访问作用域内部的局部变量，那么该变量：
// 即 内部类访问 外部局部变量
1.  要么直接就用final修饰，是一个局部常量。
2.  要么就是一个事实上的常量，即只能赋值一次，相当于用final修饰它。

在Java8之前版本的JDK中，如果不给能在局部内部类内部，访问的局部变量直接加上final修饰，会编译报错。

在最后，特别强调一点。后面学习的 匿名内部类 和 Lambda表达式 本质依然是局部内部类，这一条注意事项仍然生效。

二. 局部内部类对象作为方法的返回值, 返回值类型必须是其父类型
 */
public class Demo2 {

    public static void main(String[] args) {
        // 局部位置
        final int a = 1; //
        class Inner{
            //int a = 20;
            public void innerMethod(){
                System.out.println("a = " + a);
                // Variable 'a' is accessed from within inner class, needs to be final or effectively final
                // a = 2332; // 不能改变外部的值,相当于访问一个常量

            }

            public Inner m1(){
                return  new Inner();
            }
        }


    }

    public static Father m1(){

        class Inner extends Father{

        }

        return new Inner();
    }
}


