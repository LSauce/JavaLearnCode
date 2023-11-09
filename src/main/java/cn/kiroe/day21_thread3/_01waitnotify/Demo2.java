package cn.kiroe.day21_thread3._01waitnotify;

import cn.kiroe.test._01reflex._01introdoce.test2.SonOther;

import java.util.concurrent.TimeUnit;

/**
 * @author kiro
 * @description:
 * @data 10:05 6/11/2023
 **/
/*

验证 wait释放特点
 */
public class Demo2 {
    public static final Object OBJECT = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 创建启动一个线程
        new Thread(() -> {
            System.out.println("A线程执行了");
            synchronized (OBJECT) {
                try {
                    System.out.println("A在sync当中");
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("wait before");
                    OBJECT.wait();
                    System.out.println("wait after");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("A结束了");
        }).start();
        // sleep 为了让A线程先执行
        TimeUnit.SECONDS.sleep(1);
        // 创建并启动 一个线程
        new Thread(() -> {
            System.out.println("B开始了");
            synchronized (OBJECT) {
                System.out.println("B进入Sync");
                OBJECT.notify(); // 让处于wait的 线程准备唤醒，
                // 只有当本线程 执行完 同步，释放锁，把锁交给wait的线程，被唤醒的才能启动
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("B使用了notify");
            }
            System.out.println("B结束了");
        }).start();

        /* result:
        A线程执行了
        A在sync当中
        B开始了
        B进入Sync
        B使用了唤醒
        B结束了
        A结束了
         */
    }
}
