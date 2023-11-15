package _02dsdb.day04_list_queue._01list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 10:10 13/11/2023
 **/
public class Demo2 {

    public static void main(String[] args) {
        // subList添加 到 list中
        // 1. subList 添加到 来源list
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> integers1 = integers.subList(0, 2);
        System.out.println("integers = " + integers);
        System.out.println("integers1 = " + integers1);
        integers.addAll(integers1);
        System.out.println("integers = " + integers);// 只加list视图 中的
        // 其他list相加,也只添加 视图中的，因为 SubList 继承了AbstractList
        ArrayList<Integer> otherList = new ArrayList<>();
        List<Integer> subList2 = integers.subList(0, 1);
        otherList.addAll(subList2);
        System.out.println("otherList = " + otherList);
        System.out.println("otherList.size() = " + otherList.size());
        otherList.add(1);

    }

    @Test
    public void subListTest(){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        List<Integer> subList = list.subList(3, 5);
        subList.add(1,233);
        subList.remove(1);
        System.out.println("subList = " + subList);

    }
}
