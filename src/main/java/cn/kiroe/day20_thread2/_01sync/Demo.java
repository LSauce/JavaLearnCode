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

public class Demo {
    public static void main(String[] args) {
        // 创建3个窗口
        SellWindow sw2 = new SellWindow();
        Thread w1 = new Thread(sw2);
        Thread w2 = new Thread(sw2);
        Thread w3 = new Thread(sw2);
        w1.start();
        w2.start();
        w3.start();
    }
}

class SellWindow implements Runnable {
    int tickets = 100;
    final static Object lock = new Object();
    @Override
    public void run() {

        while (true) {
            // 某个对象 存档锁锁对象
            // 容易对象都可以当锁
            try {

                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // A在执行
            // B在sync外面等待
            // C在sync外面等待
            synchronized (Demo.class) {


                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖了第" + (tickets--) + "张票");

                }else{
                    break;
                }
            }
        }
    }
}
