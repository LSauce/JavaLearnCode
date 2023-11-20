package cn.kiroe.day21_thread3._02producerandconsumeer.priorityqueue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author kiro
 * @description:
 * @data 14:47 6/11/2023
 **/
public class Demo {

    public static void main(String[] args) {
        Queue<Integer> integers = new PriorityQueue<>();
        for (int i = 0; i < 20; i++) {
            integers.add((int) (Math.random()*100));
        }
        // 内部为 平衡二叉树，只有在 poll时才能 体现顺序
        while (!integers.isEmpty()){
            System.out.println(integers.poll());
        }

    }
}
