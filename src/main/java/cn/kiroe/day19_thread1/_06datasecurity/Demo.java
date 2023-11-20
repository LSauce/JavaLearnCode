package cn.kiroe.day19_thread1._06datasecurity;

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
public class Demo {
    public static void main(String[] args) {
        // 创建3个窗口
        Thread w1 = new SellWindow();
        Thread w2 = new SellWindow();
        Thread w3 = new SellWindow();
        w1.start();
        w2.start();
        w3.start();
    }
}

class SellWindow extends Thread {
    static int tickets = 100;

    @Override
    public void run() {
        // 循环买票
        while (true) {
            // tickets 判断
            if (tickets > 0) {
                System.out.println(getName() + "卖了第" + (tickets--) + "张票");
            }
        }
    }
}



