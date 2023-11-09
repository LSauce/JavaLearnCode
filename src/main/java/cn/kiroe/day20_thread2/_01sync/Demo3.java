package cn.kiroe.day20_thread2._01sync;

/**
 * @author kiro
 * @description:
 * @data 10:17 4/11/2023
 **/
/*

同步代码块  synchronized
    synchronized(锁对象){
        // 对共享数据的访问操作
    }
 */

public class Demo3 {
    public static void main(String[] args) {
        // 创建3个窗口
        SellWindow3 sw2 = new SellWindow3();
        Thread w1 = new Thread(sw2);
        Thread w2 = new Thread(sw2);
        Thread w3 = new Thread(sw2);
        w1.start();
        w2.start();
        w3.start();
    }
}

class SellWindow3 implements Runnable {
    final static Object lock = new Object();
    static int tickets = 100;

    @Override
    public void run() {
        int i = 0;

        while (true) {

            // 某个对象 存档锁锁对象
            // 容易对象都可以当锁
            if (i % 2 == 0) {
                synchronized (SellWindow3.class){
                    if (sellTickets2()) break;
                }
            } else {
                if (sellTickets()) break;
            }
            i++;
        }
    }
    /*
    static 同步代码块 锁对象为 类加载对象
     */
    private static synchronized boolean sellTickets() {
        // A在执行
        // B在sync外面等待
        // C在sync外面等待
        if (tickets > 0) {
            try {

                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("第二个"+Thread.currentThread().getName() + "卖了第" + (tickets--) + "张票");

        } else {
            return true;
        }

        return false;
    }

    private  boolean sellTickets2() {
        // A在执行
        // B在sync外面等待
        // C在sync外面等待
        if (tickets > 0) {
            try {

                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("第一个"+Thread.currentThread().getName() + "卖了第" + (tickets--) + "张票");

        } else {
            return true;
        }

        return false;
    }
}

