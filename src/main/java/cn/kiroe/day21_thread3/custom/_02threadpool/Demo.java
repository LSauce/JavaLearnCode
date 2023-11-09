package cn.kiroe.day21_thread3.custom._02threadpool;

import java.util.concurrent.*;

/**
 * @author kiro
 * @description:
 * @data 16:09 5/11/2023
 **/

/*

//JDK5提供了一Executors来产生线程池，有如下方法：
ExecutorService newCachedThreadPool()
// 特点:
// 1.会根据需要创建新线程，也可以自动删除，60s处于空闲状态的线程
// 2.线程数量可变，立马执行提交的异步任务（异步任务：在子线程中执行的任务）
ExecutorService newFixedThreadPool(int nThreads)
// 特点:
// 1.线程数量固定
// 2.维护一个无界队列（暂存已提交的来不及执行的任务）
// 3.按照任务的提交顺序，将任务执行完毕
ExecutorService newSingleThreadExecutor()
// 特点:
// 1.单个线程
// 2.维护了一个无界队列（暂存已提交的来不及执行的任务）
// 3.按照任务的提交顺序，将任务执行完毕
 */
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 使用线程池
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new MyRunnable());
        String s = "Test";
        // 使用 Callable<> 带返回 Future
        Future<String> submit = service.submit(new MyCallable<>(s));
        System.out.println("submit.get() = " + submit.get());


        // 直接创建一个 带返回值的线程, 使用FutureTask
        FutureTask<String> futureTask =new FutureTask<>(new MyCallable<>("FutureTask测试"));
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("futureTask.get() = " + futureTask.get()); // 使用get会阻塞,等待值


        System.out.println("Main结束");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable 执行");
    }
}
class MyCallable<T> implements Callable<T>{

    private final T T;

    MyCallable(T t) {
        T = t;
    }

    // 在 FutureTask中 run()中调用
    //
    @Override
    public T call() throws Exception {

        System.out.println("输出的为" + T);
        Thread.sleep(5000);
        return T;
    }
}

