package cn.kiroe.day22_network.homework.threadwork1;

/**
 * @author kiro
 * @description:
 * @data 19:09 6/11/2023
 **/
/*
启动2个线程，交替打印出1A2B3C4D5E6F7G
要求线程1打印数字，线程2来打印字母
请利用wait notify等待唤醒机制来实现这个需求。

使用 标记 控制循序
 */
public class ThreadWork1 {
    public static final Object OBJECT = new Object();
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (OBJECT) {

                for (int i = 0; i < 7; i++) {

                    // 自旋
                    while (flag) {
                        System.out.println("自旋中");
                        try {
                            OBJECT.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    // 1 先打印
                    System.out.print((char) ('1' + i));
                    flag = !flag;
                    try {
                        // 打印完等待，释放锁

                        OBJECT.notify();// 唤醒并不会 释放锁
                        OBJECT.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    OBJECT.notify();


                }


            }
        }, "A线程");
        new Thread(() -> {

            synchronized (OBJECT) {

                for (int i = 0; i < 7; i++) {

                    while (!flag) {
                        System.out.println("自旋中");
                        try {
                            OBJECT.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print((char) ('A' + i));
                    flag = !flag;
                    try {
                        OBJECT.notify();
                        OBJECT.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    OBJECT.notify();

                }

            }
        }, "B线程").start();
        thread.start();
    }
}
