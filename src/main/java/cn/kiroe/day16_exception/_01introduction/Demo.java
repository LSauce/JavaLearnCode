package cn.kiroe.day16_exception._01introduction;


import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 10:03 31/10/2023
 **/
/*

异常：
    简单来说异常就是用来表示Java程序运行过程中的错误(信息)

常见异常
  Error:
    java.lang.StakcOverflowError 栈异常
    java.lang.OutOfMemoryError 堆异常
  Exception:
    编译时异常
        java.lang.CloneNotsupportedException 不支持克隆异常
        java.io.FileNotFoundException
        java.io.IOException
    运行时异常：
        java.lang.ArithmeticException 算数异常
        java.lang.NullPointerException 空指针异常
        java.lang.ArrayIndexOutOfBoundsException 数组越界异常
        java.lang.ClassCastException 类型转换异常
        java.util.InputMismatchException  输入类型不匹配异常



 */
public class Demo implements Cloneable {

    public static void main(String[] args) {
       // Scanner scanner = new Scanner(System.in);
       // System.out.println("请输入一个 数字字符串");
       // int i = scanner.nextInt();
        //  java.lang.OutOfMemoryError 堆溢出了
        // int[] ints = new int[1024*1024*1024];
        // java.lang.StackOverflowError
//        func();

        Demo demo = new Demo();
        // java.lang.CloneNotSupportedException; must be caught or declared to be thrown
//        demo.clone();

        // System.out.println("10/0 = " + 10 / 0);
        // demo = null;
        // System.out.println(demo.toString());
        // String[] strs = new String[0];
        // System.out.println("strs[0] = " + strs[0]);

        Father father = new Father();
        Son son = (Son) father;

    }

    private static void func() {
        func();
    }
}

class Father{

}

class Son extends Father{

}
