package cn.kiroe.day16_exception._02handle._02trycatch;

/**
 * @author kiro
 * @description:
 * @data 11:08 31/10/2023
 **/
/*

#### 单分支

语法


方式一:
try{
   // 可能出现异常的代码
}catch(异常类型 对象名){
   // 对异常的处理操作
}
方式二:
try{
   // 可能出现异常的代码
}catch(异常类型1 | 异常类型2 | 异常类型3 | 对象名){
   // 对异常的处理操作
}



 */
public class Demo3 {

    public static void main(String[] args) throws InterruptedException {

        boolean flag = true;
        // 快捷键; com + alt + t;
        try {
            // 定义局部变量
            // 可能出现异常代码
            // 有作用域的限制
            // boolean flag = true;
            System.out.println("start");
            System.out.println(10 / 0);
            System.out.println("end");
        } catch (ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            // throw new RuntimeException(e);
            // catch 中的语句想要执行 必须类型匹配才能进来
            System.out.println("捕获到了 异常信息");
            // flag = false;
            // 获取异常信息，返回字符串。
            // getMessage()
            System.out.println("e.getMessage() = " + e.getMessage());
            // 获取异常类名和异常信息，返回字符串。
            // toString()
            System.out.println("e = " + e);
            // 获取异常类名和异常信息，以及异常出现在程序中的位置,并打印到控制台
            // printStackTrace()
            e.printStackTrace(); // 信息更加全面，为多线程的

        }
        // for (int i = 0; i < 100; i++) {
        //     System.out.println(i);
        // }

        System.out.println("main end");
        System.out.println("main end");
        System.out.println("main end");
        Thread.sleep(20);
        System.out.println("main end");
        System.out.println("main end");
    }
}
