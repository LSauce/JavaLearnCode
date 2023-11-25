package _02dsdb.day02_collection._03introduct;

import org.junit.Test;

import java.util.*;

/*

## **特点**

1. Collection是顶级接口，用描述数据存储的接口.
2. Collection的一些子实现有序，一些无序
3. 一些子实现允许存储重复的数据，一些不允许
4. 一些子实现允许存储null，一些不允许

传统的三件套。 数据存储是否有序。
 */

public class Demo3 {

    @Test
    public void test1(){
        // 2. Collection的一些子实现有序，一些无序
        // 有序与无序 指的是  是否和 存入的顺序相同或相反为有序
        // 无序的有 HashSet,HashMap
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4}));
        System.out.println("collection = " + collection);

        Collection<Integer> collection1 = new HashSet<>(Arrays.asList(new Integer[]{1,234,3,81,5}));
        System.out.println("collection1 = " + collection1);

    }

    @Test
    public void test2(){
        // 3. 一些子实现允许存储重复的数据，一些不允许
        Collection<Integer> hashSet = new HashSet<>(Arrays.asList(new Integer[]{1,2,3,33,555,3,2,1}));
        System.out.println("hashSet = " + hashSet);
    }


    @Test
    public void test3(){
        // 4. 一些子实现允许存储null，一些不允许
        // 在indexOf(Object o)  会判断o是否是 null  再判断
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(new Integer[]{null,1,32,4,null}));
        System.out.println("hashSet = " + hashSet);

        // ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(Arrays.asList(new Integer[]{1,34,45,null}));
        // System.out.println("arrayDeque = " + arrayDeque);
        // java.lang.NullPointerException

    }
}
