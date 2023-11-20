package cn.kiroe.day21_thread3._01waitnotify;

import java.util.concurrent.TimeUnit;

/**
 * @author kiro
 * @description:
 * @data 10:16 6/11/2023
 **/
/*

 */
public class Demo3 {

    public static final Object OBJECT = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println(" A执行了");
            synchronized (OBJECT){
                System.out.println(" A进入sync了");
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("A wait before");
                    // wait
                    OBJECT.wait();
                    System.out.println("A wait after");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("A 退出sync");
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            System.out.println(" B执行了");
            synchronized (OBJECT){
                System.out.println(" B进入sync了");
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("B notify before");
                    // 使用notify了
                    // notify 不会释放锁，只是唤醒 线程
                    OBJECT.notify();

                    System.out.println("B notify after");
                    // 为了让B慢一点退出 sync
                    TimeUnit.SECONDS.sleep(5);

                    System.out.println("B 将要退出 sync");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            System.out.println("B 退出了 sync");


        }).start();
    }
}
