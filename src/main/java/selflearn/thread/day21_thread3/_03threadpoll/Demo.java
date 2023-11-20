package selflearn.thread.day21_thread3._03threadpoll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kiro
 * @description:
 * @data 14:57 6/11/2023
 **/
public class Demo {
    public static void main(String[] args) {
        // 创建线程池
        // 使用 线程池工具类Executors
        ExecutorService pool = Executors.newCachedThreadPool();
        // 向线程池中 提交任务
        pool.submit(new MyTask());
        // pool.shutdown(); // 不是强制停止,等当前线程停止，不接受新的 任务
        // 使用shutdown后 无法提交新 任务
        // pool.submit(()-> System.out.println("Test"));
        // pool.shutdownNow(); // 立即强制停止


    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
