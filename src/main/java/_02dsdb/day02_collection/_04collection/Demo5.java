package _02dsdb.day02_collection._04collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author kiro
 * @description:
 * @data 17:16 10/11/2023
 **/
public class Demo5 {

    public static void main(String[] args) {
        // 调度器尝试

        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 4, 4, 5, 6, 7));
        Iterator<Integer> iterator = integers.iterator();
        System.out.println(iterator.hasNext());
        // 通过循环 迭代
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //  恢复iterator
        iterator = integers.iterator();
        //    boolean hasNext(): 是否有下一个元素
        System.out.println("iterator.hasNext() = " + iterator.hasNext());
        //    E next()： 获取下一个元素
        System.out.println("iterator.next() = " + iterator.next());
        //    void remove()： 删除刚刚遍历过的元素
        iterator.remove();
        System.out.println("integers = " + integers);

        // 使用调度器期间请 修改 集合
        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }

    }
}
