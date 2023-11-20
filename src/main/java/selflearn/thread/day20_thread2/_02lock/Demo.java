package selflearn.thread.day20_thread2._02lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kiro
 * @description:
 * @data 11:42 4/11/2023
 **/

public class Demo {
    public static void main(String[] args) {
        // 创建3个窗口
        SellWindow sw2 = new SellWindow();
        Thread w1 = new Thread(sw2, "A");
        Thread w2 = new Thread(sw2, "B");
        Thread w3 = new Thread(sw2, "C");
        w1.start();
        w2.start();
        w3.start();
    }
}

class SellWindow implements Runnable {
    final static Object locko = new Object();
    int tickets = 100;
    // 定义一把锁
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        int i = 0;
         Label:while (true) {
            System.out.println(Thread.currentThread().getName() + "执行中" + " " + i++);

            try {

                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 获取锁
            try {
                lock.lock();
                if (sell()) {
                    break;
                }
            }finally {
                lock.unlock(); // 不用 finally 会发生死锁
            }

            System.out.println("剩余："  + tickets);


        }
    }

    private boolean sell() {

        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "卖了第" + (tickets--) + "张票");
            return false;
        }else {
            return true;
        }


    }
}
