package cn.kiroe.day21_thread3.custom._08orderly;

/**
 * @author kiro
 * @description:
 * @data 20:51 5/11/2023
 **/
public class NoVisibility {
    private static  boolean ready = false; // 一定要使用 volatile
    private static int number;
    private static volatile int n = 10;

    public static void main(String[] args) throws InterruptedException {
        // 当发生n等于 0停止
        while (n != 0) {
            test();
        }
        System.out.println("n的值为0了");

    }

    public static void test() throws InterruptedException {
        Thread t = new ReaderThread();
        t.start();
        number = 42; // 有 可能能会发生重排序
        ready = true;
        t.join();
    }

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            n = number;
            // System.out.println(number);

        }
    }
}
