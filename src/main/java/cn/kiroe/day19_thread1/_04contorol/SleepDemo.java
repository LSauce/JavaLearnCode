package cn.kiroe.day19_thread1._04contorol;

import java.util.concurrent.TimeUnit;

/**
 * @author kiro
 * @description:
 * @data 15:51 3/11/2023
 **/
public class SleepDemo {
    public static void main(String[] args) {
        // 创建线程对象并启动
        new ThreadSleep().start();
    }
}

class ThreadSleep extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "------" + i);
            // sleep
            try {
                Thread.sleep(1000);
                // 等价于
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
