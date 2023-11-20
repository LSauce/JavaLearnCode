package selflearn.thread.day19_thread1._02implone;

import java.util.concurrent.TimeUnit;

/**
 * @author kiro
 * @description:
 * @data 14:34 3/11/2023
 **/
/*
1. 定义一个类继承Thread类
2. 重写run方法
3. 创建子类对象
4. 通过start方法启动线程

线程的执行特点： 随机的

 */
public class Demo4 {

    public static void main(String[] args) throws InterruptedException {

        MyThread4 myThread = new MyThread4();

        myThread.start();
        // myThread.run();
        for (int i = 0; i < 10; i++) {
            System.out.println("main thread" + Thread.currentThread().getName() +" "+ i);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}

class MyThread4 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("children thread" + Thread.currentThread().getName() + " "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
