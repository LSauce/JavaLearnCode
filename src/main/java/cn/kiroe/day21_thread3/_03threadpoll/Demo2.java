package cn.kiroe.day21_thread3._03threadpoll;

import java.util.concurrent.*;

/**
 * @author kiro
 * @description:
 * @data 15:03 6/11/2023
 **/
public class Demo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> submit = pool.submit(new MyTask2());
        System.out.println("submit.get() = " + submit.get());

        Future<String> submit1 = pool.submit(() -> {
            System.out.println("你好");
            return "成功";
        });
        System.out.println("submit1.get() = " + submit1.get());

    }
}


class MyTask2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum =0;
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}
