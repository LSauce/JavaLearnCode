package _02dsdb.day04_list_queue._01list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 09:56 13/11/2023
 **/
/*

sub list
 */
public class Demo1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        // subList只是生成一个视图，和 iterator()一样
        List<Integer> subList = list.subList(1, 3);
        System.out.println("integers = " + subList);

        list.addAll(subList);
        // subList 重写了 get,remove,内部
        // integers.get(1);// 会报错  java.util.ConcurrentModificationException
        // System.out.println("integers = " + integers);
        System.out.println("list = " + list);

        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.addAll(subList.subList(0,1));
        System.out.println("integers1 = " + integers1);


    }
}
