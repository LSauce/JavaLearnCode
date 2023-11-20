package _02dsdb.day04_list_queue.other;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author kiro
 * @description:
 * @data 17:40 13/11/2023
 **/
public class Demo8BlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<Integer> integers = new LinkedBlockingDeque<>(2);// 默认最大值 为 Integer.MAX_VALUE
        integers.put(1);
        System.out.println("add 1");
        integers.put(10);
        System.out.println("add 2");
        integers.put(10);
        System.out.println("add 3");
        integers.put(10);
        System.out.println("add 4");
        // 生产者和 消费者速率问题
        System.out.println("Main结束");
    }

    @Test
    public void test2() throws InterruptedException {
        // offer(e,time,unit) // 可设定时间，或者阻塞有返回值
        // poll(time,unit)
        System.out.println("main start");
        LinkedBlockingDeque<Integer> integers = new LinkedBlockingDeque<>(3);
        System.out.println("integers.offer(1) = " + integers.offer(1));
        System.out.println("integers.offer(1) = " + integers.offer(1));
        System.out.println("integers.offer(1) = " + integers.offer(1));
        System.out.println("integers.offer(1) = " + integers.offer(1));
        integers.offer(1,1, TimeUnit.SECONDS);
        System.out.println("main end");
    }
}
