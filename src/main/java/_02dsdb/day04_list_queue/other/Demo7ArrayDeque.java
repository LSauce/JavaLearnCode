package _02dsdb.day04_list_queue.other;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @author kiro
 * @description:
 * @data 17:02 13/11/2023
 **/
public class Demo7ArrayDeque {

    @Test
    public void test(){
        // 在 ArrayDeque中，向将这个操作转换一下
        // tail = (tail+1) % length =  (tail+1)&(length-1);
        // 有一个前提 length 为2的次幂方
        // 设置限制不了最大容量
        // 为循环数组，有两个头和尾下标
        ArrayDeque<Integer> integers = new ArrayDeque<>(7);
        //         elements = new Object[16];
        // 默认长度为 16；
        integers.add(10);
        // 我们发现扩容是安装两倍进行的，确保容量一直是 2的幂次方

        System.out.println(calculateSize(1023));
    }

    private static final int MIN_INITIAL_CAPACITY = 8;
    // 将 numElements 全变为1，再加1，即可获得最近 值
    // 通过 每次右移
    private static int calculateSize(int numElements) {
        int initialCapacity = MIN_INITIAL_CAPACITY;
        // Find the best power of two to hold elements.
        // Tests "<=" because arrays aren't kept full.
        if (numElements >= initialCapacity) {
            initialCapacity = numElements;           // 输入 17            //0001 0001
            initialCapacity |= (initialCapacity >>>  1);// 0001 0001 位移--> 0000 1000 -->|= 0001 10001

            initialCapacity |= (initialCapacity >>>  2);// 0001 10001// 这时一定有 两个1 在前面
            initialCapacity |= (initialCapacity >>>  4);// 这时一定有4个1 在前面
            initialCapacity |= (initialCapacity >>>  8);// 这时一定有8个1 在前面
            initialCapacity |= (initialCapacity >>> 16);// 这时一定有16个1 在前面
            initialCapacity++;

            if (initialCapacity < 0)   // Too many elements, must back off
                initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
        }
        return initialCapacity;
    }
}
