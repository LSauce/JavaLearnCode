package cn.kiroe.day22_network.homework.waitandnotifywork;

/**
 * @author kiro
 * @description:
 * @data 21:02 6/11/2023
 **/
/*
通过 判断 线程的序号，来判断改阻塞的线程
通过线程携带xing
 */
public class WaitAndNotifyWork3 {

    public static void main(String[] args) throws InterruptedException {
        AddNumTask addNumTask = new AddNumTask(75, 5,3);
        new Thread(addNumTask, "1").start();
        new Thread(addNumTask, "2").start();
        new Thread(addNumTask, "3").start();
    }
}

class AddNumTask implements Runnable {
    private static volatile int num;
    private static int endNum;
    private static int step;

    private static  int threadCount = 0;

    // 统计多少线程启动
    public AddNumTask(int endNum, int step,int threadCount) {
        AddNumTask.endNum = endNum;
        AddNumTask.step = step;
        AddNumTask.threadCount = threadCount;
    }

    @Override
    public void run() {
        synchronized (AddNumTask.class) {
            while (num < endNum) {
                System.out.println(Thread.currentThread().getName() + " 进来了");
                // 判断当前线程是否该执行
                System.out.println(Thread.currentThread().getName() + " "+ isCorrectThread(Thread.currentThread()));
                if (isCorrectThread(Thread.currentThread())) {

                    for (int i = 0; i < step; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + ++num);
                    }
                    AddNumTask.class.notifyAll();
                }else {
                    try {
                        AddNumTask.class.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


            }
        }
    }

    private boolean isCorrectThread(Thread thread) {
        int threadId = Integer.parseInt(thread.getName());
        return threadId == (num / step) % threadCount + 1;
    }
}

