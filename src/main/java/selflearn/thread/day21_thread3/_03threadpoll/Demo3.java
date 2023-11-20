package selflearn.thread.day21_thread3._03threadpoll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kiro
 * @description:
 * @data 15:12 6/11/2023
 **/
public class Demo3 {

    public static void main(String[] args) {
        // ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Executors.newCachedThreadPool();
        pool.submit(new MyTask3());
        pool.submit(new MyTask3());
        pool.submit(new MyTask3());
        pool.submit(new MyTask3());

        pool.submit(MyTask3::new);
        pool.shutdown();
    }
}

class MyTask3 implements Runnable{

    public MyTask3() {
        run();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+ " :"+ i);
        }
    }
}
