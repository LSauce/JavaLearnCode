package cn.kiroe.day19_thread1._02implone;

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
public class Demo3 {

    public static void main(String[] args) {

        MyThread3 myThread = new MyThread3();
        MyThread3 myThread2 = new MyThread3();

        myThread.start();
        myThread2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main thread" + Thread.currentThread().getName() +" "+ i);

        }
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("children thread" + Thread.currentThread().getName() + " "+i);

        }


    }
}
