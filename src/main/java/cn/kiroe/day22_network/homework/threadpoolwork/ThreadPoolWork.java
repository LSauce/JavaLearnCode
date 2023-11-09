package cn.kiroe.day22_network.homework.threadpoolwork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author kiro
 * @description:
 * @data 19:54 6/11/2023
 **/
/*
创建一个可自由扩容的线程池，然后向线程池提交十个任务
这十个任务中的每个任务都会随机睡眠0-10s，睡眠结束后打印睡眠时间就结束任务
请完成这个线程池语法练习题
 */
public class ThreadPoolWork {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<Long>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Long> submit = pool.submit(new RunSleepTask(1000L));
            list.add(submit);
        }

        pool.submit(()->{
            for (int i = 0; i < list.size(); i++) {
                try {
                    System.out.println(i+1+ "实际时间为"+ list.get(i).get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }
}

// 返回实际睡眠时间
class RunSleepTask implements Callable<Long> {
    private final long maxSleepMillis;


    public RunSleepTask(Long maxSleepMillis) {
        this.maxSleepMillis = maxSleepMillis;
    }

    @Override
    public Long call() throws InterruptedException {
        System.out.println("进来了");
        long sleepTime = (long) (Math.random()*maxSleepMillis);
        long startTime = System.currentTimeMillis();
        Thread.sleep(sleepTime);
        System.out.println(Thread.currentThread().getName()+" 我睡了"+ sleepTime);
        // 返回实际睡的时间
        return System.currentTimeMillis() - startTime;
    }
}
