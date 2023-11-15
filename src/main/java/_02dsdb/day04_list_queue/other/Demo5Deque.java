package _02dsdb.day04_list_queue.other;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 15:25 13/11/2023
 **/
public class Demo5Deque {

    public static void main(String[] args) {
        ArrayDeque<Integer> integers = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("integers = " + integers);
        System.out.println("integers.remove() = " + integers.remove());
        System.out.println("integers.remove() = " + integers.remove());
        // 对列是 操作受限的线性表(数组链表)，
        integers.remove(3);
        System.out.println("integers = " + integers);

        // //boolean add(E e): 将指定的元素插入此队列（如果立即可行且不会违反容量限制），在成功时返回 true，如果当前没有可用的空间，则抛出 IllegalStateException。
        integers.add(32);
        // //E remove():获取并移除此队列的头。
        integers.remove();
        // //E element() :获取，但是不移除此队列的头。
        integers.element();
        // //boolean offer(E e):将指定的元素插入此队列（如果立即可行且不会违反容量限制），
        // 当使用有容量限制的队列时，此方法通常要优于 add(E)，后者可能无法插入元素，
        // 而只是抛出一个异常。
        integers.offer(10);
        System.out.println("integers = " + integers);
        // //E poll():获取并移除此队列的头，如果此队列为空，则返回 null。
        System.out.println("integers.poll() = " + integers.poll());
        // //E peek(): 获取但不移除此队列的头；如果此队列为空，则返回 null。
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
    }

    @Test
    public void dequeTest(){
        System.out.println("test");
        ArrayDeque<Integer> integers = new ArrayDeque<>(2);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);

        // ArrayQueue<Integer> integers1 = new ArrayQueue<>(2);
        // integers1.add(1);
        // integers1.add(1);
        // integers1.add(1);
        // integers1.add(1);

    }
}
