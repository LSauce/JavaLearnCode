package selflearn.thread.day19_thread1.homework.work3;

/**
 * @author kiro
 * @description:
 * @data 20:13 3/11/2023
 **/
/*
有3个线程,T1,T2,T3, 请确保: T1线程先执行，T2在T1之后执行,T3在T2执行完后执行

提示: 利用线程控制API
 */
public class ThreadWork3 {
    public static void main(String[] args) throws InterruptedException {
        // useJoin();

    }

    private static void useJoin() throws InterruptedException {
        Thread t1  = new Thread(new MyRunnable());
        Thread t2  = new Thread(new MyRunnable());
        Thread t3  = new Thread(new MyRunnable());
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
    }
}

// 传入前驱
class MyRunnable implements Runnable {
    @Override
    public void run() {

            System.out.println("目前是 " + Thread.currentThread().getName());

    }

    public MyRunnable() {

    }
}
