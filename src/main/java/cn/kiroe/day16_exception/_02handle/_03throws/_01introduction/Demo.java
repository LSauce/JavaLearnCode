package cn.kiroe.day16_exception._02handle._03throws._01introduction;

/**
 * @author kiro
 * @description:
 * @data 11:36 31/10/2023
 **/
/*

throws 关键字 表示抛出 异常的可能性
使用在方法声明处， 形参列表的后面
throws + 异常列表(使用,隔开)
 */
public class Demo {

    public static void main(String[] args) {
        // fun0();
        // fun1();


        // Unhandled exception: java.lang.CloneNotSupportedException

        try {
            fun2();
        } catch (CloneNotSupportedException e) {
            System.out.println("捕获到了 克隆异常");
        }
    }

    // throws + 编译时异常 --> 表示该异常不在 此处理，交给方法的调用者 处理
    private static void fun2() throws CloneNotSupportedException {
        Demo demo = new Demo();
        demo.clone();

    }

    // 不加throws
    private static void fun0() {
        // do some thing
        System.out.println("func1 start");
        System.out.println(10 / 0);
        System.out.println("func1 end");

    }

    // throws + 运行时异常 --> 没有太大意义
    // 常列表: 异常类型1, 异常类型2, .... 用逗号隔开，列表中的异常不要出现父子关系，如果有，那么编译器只会强制处理父类
    private static void fun1() throws NullPointerException, RuntimeException, ArrayIndexOutOfBoundsException, ArithmeticException {
        // do some thing
        System.out.println("func1 start");
        System.out.println(10 / 0);
        System.out.println("func1 end");

    }
}
