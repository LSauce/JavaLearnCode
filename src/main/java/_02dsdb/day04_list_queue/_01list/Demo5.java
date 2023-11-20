package _02dsdb.day04_list_queue._01list;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 11:15 13/11/2023
 **/
public class Demo5 {
    public static void main(String[] args) {
        // 看源码使用ArrayList接
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 34, 5));
        integers.add(10);

        integers.remove(10);
        integers.remove(new Integer(10));
        integers.contains(10);
    }
}
