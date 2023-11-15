package _02dsdb.day04_list_queue.other;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author kiro
 * @description:
 * @data 14:35 13/11/2023
 **/
public class LinkedListDemo1 {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(1,2,3,4,5,6));
        integers.add(10);
        integers.listIterator(3);
        // Stack 为 Vector的子类
        // LinkedList 实现了 Deque结果
        // 为节省 内存，使用 头部和尾部的游标，并没有浪费空间，
        /*
        void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
         */
    }
}
