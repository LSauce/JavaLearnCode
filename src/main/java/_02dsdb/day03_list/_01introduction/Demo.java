package _02dsdb.day03_list._01introduction;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 10:59 11/11/2023
 **/
/*
1. List是Collection的子接口。（父子继承关系，想对原有接口进行增强。）
2. 数据结构表现为线性表。
3. 存储数据有序。（存储进去的顺序和读取出来的顺序。 完全一致或者完全相反）
4. 可以存储重复元素
5. 可以存储null
 */
public class Demo {
    public static void main(String[] args) {
        // List
        List<String> list = new ArrayList<>(Arrays.asList("1","2","3","4","3","4"));
        // 3. 存储数据有序。（存储进去的顺序和读取出来的顺序。 完全一致或者完全相反）
        list.add("3");
        // 4. 可以存储重复元素
        // 5. 可以存储null
        list.add(null);
        System.out.println("list = " + list);
        // 与Collection 对比
        // 1.增删改查
        list.add("2");
        list.remove("1");


        // 特殊的api
        list.size();
        list.clear();
        list.isEmpty();
        // 遍历的api
        list.toArray();
        list.toArray(new String[0]);

        Iterator<String> iterator = list.iterator();



    }

    @Test
    public void test2(){
        // 1. 储存数据是有序的
    }
}
