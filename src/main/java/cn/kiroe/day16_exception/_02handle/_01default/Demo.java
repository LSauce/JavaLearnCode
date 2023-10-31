package cn.kiroe.day16_exception._02handle._01default;

import javax.xml.transform.Source;

/**
 * @author kiro
 * @description:
 * @data 11:02 31/10/2023
 **/
/*
    Exception in thread "main" java.lang.ArithmeticException: / by zero
	at cn.kiroe.day16_exception._02handle._01default.Demo.main(Demo.java:14)
	异常发生的线程: main
    异常的类型: 	java.lang.ArithmeticException
    错误原因: /by zero
    具体的位置： 哪个类 那个方法 哪行代码

 */
public class Demo {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        System.out.println("strat");
        System.out.println(10/0); // java.lang.ArithmeticException: / by zero
        System.out.println("end");
    }
}
