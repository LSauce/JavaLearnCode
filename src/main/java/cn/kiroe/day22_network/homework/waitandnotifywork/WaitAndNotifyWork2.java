package cn.kiroe.day22_network.homework.waitandnotifywork;

/**
 * @author kiro
 * @description:
 * @data 20:30 6/11/2023
 **/
/*
选做)启动3个线程打印递增的数字使用wait notifyAll

(稍微有点难,有困难的同学可以选做或看参考答案,理解了自己把答案盖住再写)

线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10,
然后是线程3打印11,12,13,14,15.
接着再由线程1打印16,17,18,19,20....
以此类推, 直到打印到75

使用两个锁，分别锁
线程1，线程2  为一把锁 保证 有序性

再加一把锁
线程3， 保证 有序性

锁无法做到传递性，要有序 不如 使用 join
 */

public class WaitAndNotifyWork2 {
    public static final Object OBJECT = new Object();
    public static final Object OBJECT2 = new Object();
    public static final Object OBJECT3 = new Object();
    public static final int endNum = 75;
    public static final int step = 5;
    public static volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {

        // 线程一
        new Thread(() -> {
            synchronized (OBJECT) {
                while (num != endNum) {
                    for (int i = 0; i < step; i++) {
                        System.out.println(Thread.currentThread().getName() + ++num);
                    }
                    try {
                        OBJECT.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    OBJECT.notify();
                }
            }
        }, "线程一").start();
        Thread.sleep(100);
        new Thread(() -> {


            while (num != endNum) {

                synchronized (OBJECT) {
                    for (int i = 0; i < step; i++) {
                        System.out.println(Thread.currentThread().getName() + ++num);
                    }

                    synchronized (OBJECT2) {
                        OBJECT2.notify();
                        try {
                            OBJECT2.wait();

                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    try {
                        OBJECT.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    OBJECT.notify();
                }


            }
        }, "线程二").start();
        Thread.sleep(100);

        new Thread(() -> {
            while (num != endNum) {
                synchronized (OBJECT2) {
                    for (int i = 0; i < step; i++) {
                        System.out.println(Thread.currentThread().getName() + ++num);
                    }
                    OBJECT2.notify();
                    try {
                        OBJECT2.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (OBJECT) {
                        OBJECT.notify();
                        try {
                            OBJECT.wait();

                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        }, "线程三").start();


    }

}
