package cn.kiroe.day22_network.homework.waitandnotifywork;

/**
 * @author kiro
 * @description:
 * @data 20:14 6/11/2023
 **/
/*
(选做)启动3个线程打印递增的数字使用wait notifyAll

(稍微有点难,有困难的同学可以选做或看参考答案,理解了自己把答案盖住再写)

线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10,
然后是线程3打印11,12,13,14,15.
接着再由线程1打印16,17,18,19,20....
以此类推, 直到打印到75
 */
public class WaitAndNotifyWork {
    public static void main(String[] args) {

        // 建立三条不一样的线程，让他们 直接按照循序，使用join？不好。。。

    }
}

// 设置开头与结束
/*
    增加值至
 */
class AddNumTask2 implements Runnable {
    private static volatile int num;
    private static int endNum;
    private static int step;

    public AddNumTask2(int endNum, int step) {
        AddNumTask2.endNum = endNum;
        AddNumTask2.step = step;
    }

    @Override
    public void run() {
        synchronized (AddNumTask.class) {
            while (num != endNum) {
                for (int i = 0; i < step; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + num++);
                }
            }
        }
    }
}
