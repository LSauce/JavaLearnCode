package _02dsdb.day04_list_queue.other;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author kiro
 * @description:
 * @data 16:03 13/11/2023
 **/
public class Demo5Queue2 {
    /*

     */
    public static void main(String[] args) {
        // 只是设置默认大小，扩容为 原来的 1.5倍
        ArrayList<Integer> integers = new ArrayList<>(2);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println("integers = " + integers);
        // 自动扩容为原来的 两倍
        // 可设置容量
        ArrayQueue<Integer> deque = new ArrayQueue<>(3);
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(3);
        System.out.println("deque = " + deque);

        //BlockingQueue
        LinkedBlockingQueue<Integer> integers1 = new LinkedBlockingQueue<>(2);
        integers1.add(1);// java.lang.IllegalStateException: Deque full
        integers1.add(1);
        //integers1.add(1);
        //integers1.add(1);
        System.out.println("integers1.offer(233) = " + integers1.offer(233));
        integers1.remove();
        integers1.remove();
        //integers1.remove();
        System.out.println("integers1.poll() = " + integers1.poll());// 返回null
        System.out.println("integers1 = " + integers1);
        // offer，poll与add,remove不同
        // offer不抛异常，在队列满，或者为零时
        // add抛异常


    }
}
