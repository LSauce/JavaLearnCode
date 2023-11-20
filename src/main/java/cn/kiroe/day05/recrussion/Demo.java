package cn.kiroe.day05.recrussion;

/**
 * @author kiro
 * @description:
 * @data 14:34 17/10/2023
 **/
public class Demo {
    public static void main(String[] args) {
        //m1();
        //m2();
        //System.out.println(sum(10));
        //System.out.println("factorial(10) = " + factorial(3));
        System.out.println("fibolacci(5) = " + fibolacci(5));

    }
    // 青蛙跳台阶： 已知
    // f(n) = f(n-2) + f(n-1)  两种方式

    //斐波那契数列  1,1,2,3,5,  f(n) = f(n-1) + f(n-2)
    public static int fibolacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibolacci(n - 2) + fibolacci(n - 1);
    }

    //n的阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    //自然数求和：
    public static int sum(int n) {
        // 递归出口
        if (n == 1) {
            return 1;
        }
        //递归 公式
        return n + sum(n - 1);

    }

    public static void m1() {
        // xxxException ----> 异常
        // XXXError ----> 错误
        // java.lang.StackOverflowError
        m1();
    }

    public static void m2() {

        int[] a = new int[1024 * 1024 * 1024];
    }
}
