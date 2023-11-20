package cn.kiroe.day20_thread2._01sync;

import java.util.concurrent.TimeUnit;

/**
 * @author kiro
 * @description:
 * @data 11:09 4/11/2023
 **/
/*
synchronized 同步代码块 执行流程
 */
public class Demo4 {
    // 定义一把锁
    public static final Object OBJECT = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 创建并启动线程
        new Thread(() -> {
            System.out.println("A这个线程执行了");
            synchronized (OBJECT) {
                System.out.println("A线程进入到 synchronized" + System.currentTimeMillis());
                // 睡眠
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("A线程退出 synchronize"+ System.currentTimeMillis());

        }, "A").start();
        // 保证A先拿到锁
        Thread.sleep(1000);

        // 创建并启动一个线程
        new Thread(() -> {
            System.out.println("B这个线程执行了" + System.currentTimeMillis());
            // 即使B线程已经执行了， 但没有锁 只能在synchronized等待，
            // 称为 同步阻塞
            // 因为锁还没有释放，造成的阻塞
            // OBJECT为锁标记对象，相当于有钥匙，但反锁了
            synchronized (OBJECT) {
                System.out.println("B线程进入到 synchronized" + System.currentTimeMillis());
            }
            System.out.println("B线程退出 synchronized" + System.currentTimeMillis());
        }, "B").start();
    }
}
