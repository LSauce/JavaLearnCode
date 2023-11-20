package cn.kiroe.day21_thread3.custom._6visibility._01introduce;

import java.util.concurrent.TimeUnit;

/**
 * @author kiro
 * @description:
 * @data 17:35 5/11/2023
 **/
public class Demo {
    // 当不使用 volatile修饰时 无法关闭
    private static boolean running = true;
    private static A aO1 = new A();
    private static volatile A runningA = aO1;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            new A().m();
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        // running = false;
        // runningA  = new A();
        // 无法停止，对象内部布局有可见性
        // A.runflag  = false;
    }

    private static class A {
        public static boolean runflag = true;
        void m() {
            System.out.println("m start");
            // while (running) {
            //     // 当使用某些语句时，会触发 线程 工作内存的同步刷新
            //     // System.out.println("mmm");
            // }
            //
            // while (runningA == aO1) {
            //
            // }
            while (runflag){

            }

            System.out.println("m end");
        }
    }


}
