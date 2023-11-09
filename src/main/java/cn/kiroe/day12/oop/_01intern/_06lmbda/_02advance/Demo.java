package cn.kiroe.day12.oop._01intern._06lmbda._02advance;

//无返回值无参数的功能接口
@FunctionalInterface
interface INoReturnNoParam {
    void test();
}

//无返回值有一个参数的功能接口
@FunctionalInterface
interface INoReturnOneParam {
    void test(int a);
}

//无返回值两个参数的功能接口
@FunctionalInterface
interface INoReturnTwoParam {
    void test(int a, int b);
}

//有返回值无参数的功能接口
@FunctionalInterface
interface IHasReturnNoParam {
    int test();
}

//有返回值一个参数的功能接口
@FunctionalInterface
interface IHasReturnOneParam {
    int method(int a);
}

//有返回值两个参数的功能接口
@FunctionalInterface
interface IHasReturnTwoParam {
    int test(int a, int b);
}

/**
 * @author kiro
 * @description:
 * @data 10:51 27/10/2023
 **/

/*

1. (形参列表)能不能简化呢？是可以的，因为功能接口中有且仅有一个必须要实现的抽象方法，那么：

   1. ==形参的数据类型是可以省略的==，因为方法已经固定死了，形参一定是那些，
   不需要写出来。但形参的名字是不可省略的（因为要在方法体中使用）
   2. 特殊情况下：
      - 如果形参列表中的形参只有一个，那么()小括号，也是可以省略的。
      - 但是如果形参为空，()小括号是不可以省略的。

2. { //方法体 }方法体能不能简化呢？当然是可以的：

   1. 如果方法重写的方法体只有一条语句的话，那么可以省略大括号。（类似于if/for省略大括号）
   2. 特殊的，如果只有一条语句且这条语句是返回值语句，那么大括号和return可以一起省略。

3. 实际上在多数情况下，都不太可能一句话把方法体写完。多数情况下，
Lambda表达式的抽象方法实现都会很复杂，那这样Lambda表达式就会写的很复杂，
这就很难受了。而Lambda表达式，本质上就是重写了一个抽象方法的子类对象
，所以Java允许Lambda表达式的抽象方法的实现可以直接指向一个已经存在的方法，
而不是自己书写实现。这种语法在Java中称之为"方法引用"！
 */
public class Demo {

    public static void main(String[] args) {
        //无返回值有一个参数的功能接口
        INoReturnOneParam iNoReturnOneParam = (int a) -> {
            System.out.println(a);
        };
        iNoReturnOneParam.test(10);
        //简化写法
        INoReturnOneParam ip2 = (a) -> System.out.println(a);
        ip2.test(233);

        INoReturnTwoParam ip3 = (int a, int b) -> System.out.println(a + b);
        ip3.test(3, 5);

        //形参进行简化
        INoReturnTwoParam ip4 = (a, b) -> System.out.println(a + b);
        ip4.test(1, 2);

        // 特殊情况
        INoReturnOneParam ip5 = a -> System.out.println(a);
        ip5.test(23);
        // 形参为空，不能省略 () // Unexpected token
        INoReturnNoParam ip6 = () -> System.out.println("test");
        ip6.test();
        // 方法体的简化， 当只有一条语句时 {} 可以省略
        INoReturnNoParam ip7 = () -> System.out.println(111);
        ip7.test();

        IHasReturnTwoParam ip8 = (a, b) -> {
            System.out.println(a + b);
            return a + b;
        };

        System.out.println("ip8.test(10,32) = " + ip8.test(10, 32));
        // 简化大括号,如果有返回值，只有一条语句 ，可大括号和return 也不用加
        IHasReturnTwoParam ip9 = (a,b) -> a+b;
        System.out.println("ip9.test(10,20) = " + ip9.test(10, 20));

        // 带一个参数是
        IHasReturnOneParam ip10 = a -> a*3;
        System.out.println("ip10.method(20) = " + ip10.method(20));



    }
}
