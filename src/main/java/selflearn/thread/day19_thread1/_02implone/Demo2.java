package selflearn.thread.day19_thread1._02implone;

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
 */
public class Demo2 {

    public static void main(String[] args) {

        MyThread2 myThread = new MyThread2();
        myThread.start();


        while (true) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        while (true) {

            System.out.println("children thread" + Thread.currentThread().getName());
        }
    }
}
