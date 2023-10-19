package cn.kiroe.day04._03memory;

public class Demo2 {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = a + b;
        long l = Runtime.getRuntime().maxMemory();
        System.out.println("l = " + l/1024/1024);
    }
}
