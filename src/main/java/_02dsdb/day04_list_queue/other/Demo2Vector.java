package _02dsdb.day04_list_queue.other;

import java.util.Arrays;
import java.util.Vector;

/**
 * @author kiro
 * @description:
 * @data 14:54 13/11/2023
 **/
public class Demo2Vector {
    public static void main(String[] args) {
        Vector<Integer> integers = new Vector<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("integers = " + integers);

        // Vector 上面都有synchronized 是线程安全的，但大部分常见下，我们不需要使用多线程
        // 这个一般写代码不使用，一般在面试时 使用

        // 从大到小，首先回答

    }
}
