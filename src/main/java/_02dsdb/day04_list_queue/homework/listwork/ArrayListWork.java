package _02dsdb.day04_list_queue.homework.listwork;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author kiro
 * @description:
 * @data 19:29 13/11/2023
 **/
/*
假如我有一个ArrayList对象存储了一些数据, 如果我们想遍历这些数据, 可以通过哪些循环或者迭代来做


 */

public class ArrayListWork {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        // for i  get(i)方法
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
        // 迭代器
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // 迭代器for each
        for (Integer integer : integers) {
            System.out.println(integer);
        }

        // 使用toArray
        Integer[] array = integers.toArray(new Integer[0]);
        for (Integer i : array) {
            System.out.println(i);
        }
        
        // ListIterator遍历
        ListIterator<Integer> integerListIterator = integers.listIterator(integers.size());
        while (integerListIterator.hasPrevious()){
            System.out.println("integerListIterator.previous() = " + integerListIterator.previous());
        }


    }
}
