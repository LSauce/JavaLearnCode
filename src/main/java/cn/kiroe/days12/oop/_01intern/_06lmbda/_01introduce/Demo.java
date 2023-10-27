package cn.kiroe.days12.oop._01intern._06lmbda._01introduce;

/*

外部类静态方法中 访问 静态内部类，直接 new 静态内部类
静态内部类 与 类对象无关
主要 在于是否依赖对象，非静态的依赖，静态的依赖
 */
@FunctionalInterface
interface IA {

    void m1();

}

@FunctionalInterface
interface IC {

    void m1();

    default void m2() {
        System.out.println(1111);
    }

    @Override
    boolean equals(Object object);
}

interface IE {

    void m1(String s);
}


interface IF {
    String m1(String s);
}

/**
 * @author kiro
 * @description:
 * @data 17:52 26/10/2023
 **/

/*

Lambda 表达式是 JDK8 的一个新特性，可以取代接口的匿名内部类，写出更优雅的Java 代码。

1. Lambda表达式仍然是局部内部类，是特殊的局部内部类，仍然定义在局部位置。而且局部内部类的注意事项，也一样存在。
2. Lambda表达式在取代匿名内部类时，不是全部都取代，而是取代**接口**的匿名内部类，而类的匿名内部类Lambda表达式是不能取代的。
3. Lambda表达式是匿名内部类的更进一步， Lambda表达式得到的也不是一个类，而是一个对象，并且是接口的子类对象。


 Lambda表达式虽然说是取代==接口的匿名内部类==，
 但也不是什么接口都能用Lambda表达式创建子类对象。

Lambda表达式要求的接口中，必须==有且仅有一个必须要实现的抽象方法==。
这种接口在Java中，被称之为"功能接口"。功能接口在语法上，
可以使用注解==@FunctionalInterface==标记在接口头上，用于==检测一个接口是否是功能接口==。


(形参列表) -> {
// 方法体

}
1. (形参列表)表示功能接口中，必须要重写的抽象方法的形参列表。
2. ->由一个英文横杠 + 英文大于号字符组成，它是Lambda表达式的运算符，读作goes to。
3. { //方法体 }表示功能接口中，必须要重写的抽象方法的，方法体实现。

lambda表达式的 类型推断
1. 使用引用接收
2. 类型转换
    ((父接口的名字)Lambda表达式).方法名(实参)
3. 借助方法
 */


public class Demo {

    public static void main(String[] args) {

        // 不知道 lambda是哪个类型的接口
        /* () ->{
            System.out.println("test");
        };*/

        // 使用 父引用接收
        IA ia = () -> {
            System.out.println("IA");
        };
        ia.m1();

        // 使用强制转换
        ((IA)()->{
            System.out.println("test");
        }).m1();
        // 借助方法的 形参类型

        test1().m1("testtestsetsetest");

        test2((String s)->{
            System.out.println(s);
        },"testIEEEE");

    }


    // 借助于方法 的 返回值
    public static IE test1(){
        return (String s) -> {
            System.out.println(s);
            System.out.println(s);
        };
    }

    // 借助方法的 形参类型
    public static void test2(IE ie, String s){
       ie.m1(s);
    }
}
