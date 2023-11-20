package cn.kiroe.day04._05exception;

public class Demo {
    /*

    异常：
      描述Java程序中的错误信息
 Exception in thread "main" java.lang.ArithmeticException: / by zero
	at cn.kiroe.day04._05exception.Demo.main(Demo.java:13)
     Exception in thread "main" 在main线程中
     java.lang.ArithmeticException: 异常类型 算数异常
     / by zero ： 异常原因
      数值中常见的错误
        1. 数值越界异常
            java.lang.ArrayIndexOutOfBoundsException
        2. 空指针异常
            java.lang.NullPointerException




     */
    public static void main(String[] args) {
        System.out.println("main start");
        //System.out.println(1 / 0);
        int[] arr = new int[10];
//        System.out.println(arr[10]);

        //遍历数组中遇到
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        int[] arr2 = null;//没指向 堆上任何对象
        System.out.println(arr2[0]);

        int[] arr3;
        //没有初始化的数组无法使用
        int a; // 没有初始化的 变量都无法使用
        //System.out.println(a + arr3);
        int[] arr4 = null;
        System.out.println(arr4);
    }
}
