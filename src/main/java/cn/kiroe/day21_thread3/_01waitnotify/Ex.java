package cn.kiroe.day21_thread3._01waitnotify;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author kiro
 * @description:
 * @data 10:32 6/11/2023
 **/
/*
创建2个线程A  B

A线程打印1,B线程打印2, A线程打印3, B打印4.... B线程打印100(使用wait notify)
 */
public class Ex {
    public static final Object OBJECT = new Object();
    public static volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (OBJECT) {
                while (num != 100) { //最后 在这里结束
                    num++;
                    System.out.println("A" + num);

                    try {
                        OBJECT.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    OBJECT.notify();
                }
                System.out.println("A结束了");
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {

            synchronized (OBJECT) {
                while (num != 100) {// 变为同步的了
                    num++;
                    System.out.println("B" + num);
                    OBJECT.notify();
                    try {
                        OBJECT.wait(); // wait只是一个提前 释放锁的机制,会 释放锁
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                System.out.println("B结束了");

            }
        }).start();
    }
}
