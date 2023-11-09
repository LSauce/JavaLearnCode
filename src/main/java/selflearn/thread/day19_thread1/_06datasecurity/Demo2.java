package selflearn.thread.day19_thread1._06datasecurity;

/**
 * @author kiro
 * @description:
 * @data 17:40 3/11/2023
 **/
/*
假设A电影院正在上映某电影，该电影有100张电影票可供出售，
现在假设有3个窗口售票。请设计程序模拟窗口售票的场景。

分析：
3个窗口售票，互不影响，同时进行。 -----> 多线程  3个线程
3个窗口共同出售这100张电影票		-------> 多线程共享数据
// 多线程实现方式一
 */
public class Demo2 {
    public static void main(String[] args) {
        // 创建3个窗口
        SellWindow2 sw2 = new SellWindow2();
        Thread w1 = new  Thread(sw2);
        Thread w2 = new  Thread(sw2);
        Thread w3 = new  Thread(sw2);
        w1.start();
        w2.start();
        w3.start();
    }
}

class SellWindow2 implements Runnable {
    int tickets = 100;

    @Override
    public void run() {
        // 循环买票
        while (true) {

            // 不存在票的分析
            // 假设A先执行 t=1
            // b t=1
            // c t=1
            // tickets 判断
            if (tickets > 0) {

                try {
                    //到这睡觉
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "卖了第" + (tickets--) + "张票");
                // tickets--
                // 可分三部 取值，减一，赋值， 三个原子操作
                // A先执行 1 ，0
                // B执行  0， -1
                // c执行 -1 ，2
            }
        }
    }
}



