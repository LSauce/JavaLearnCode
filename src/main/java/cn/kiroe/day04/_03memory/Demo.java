package cn.kiroe.day04._03memory;

public class Demo {
    public static void main(String[] args) {
        test1();
    }

    // JVM栈中存 局部变量
    public static void test1() {
        System.out.println("test1");
        int a = 1;
        int[] arr = {1, 2, 3, 4};
        test2();
    }

    public static void test2() {
        System.out.println("test2");
        int a = 0;
    }
}
