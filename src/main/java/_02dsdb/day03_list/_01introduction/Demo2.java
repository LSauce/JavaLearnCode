package _02dsdb.day03_list._01introduction;

import java.util.*;

/**
 * @author kiro
 * @description:
 * @data 11:09 11/11/2023
 **/
/*
list 接口为 collection的增强
会新增api
 */

public class Demo2 {

    public static void main(String[] args) {
        //  List是线性表的实现，所以它相对于Collection增加了很多下标相关的API
        Collection<String> collection = new ArrayList<>();
        collection.add("test");
        // 只能使用List才能使用 下面方法，List新增的 方法与下标有关
        //    void add(int index, E element)： 在指定位置添加元素。list添加的位置，只能在[0,length之间]
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        strings.add(2,"test1"); // rangeCheckForAdd,java.lang.IndexOutOfBoundsException
        System.out.println("strings = " + strings);
        //    boolean addAll(int index, Collection<? extends E> c)： 在指定位置添加一个Collection的所有元素
        strings.addAll(1,Arrays.asList("12","dfa","fd"));
        //    E remove(int index)：删除指定下标的元素，只能删除下标的位置[0, size-1]。返回的是删除的元素
        strings.remove(2);
        // 默认 使用 final修饰变量，当 必须要改变时 不加
        //    E set(int index, E element)： 设置指定下标的元素为element
        strings.set(strings.size()-1,"fdsf");// [0, list.size()-1]
        System.out.println("strings = " + strings);
        //    E get(int index)： 获取指定下标元素
        System.out.println("strings.get(2) = " + strings.get(2));


        // list接口遍历
        // 1. toArray()
        // 2. iterator()
        // 3. foreach
        // 4. fori
        // 如果不需要下标，优先使用 迭代器
        for (int i = 0; i < strings.size(); i++) {
            System.out.println("strings.get("+i+") = " + strings.get(i));
        }


        //    int indexOf(Object o)： 获取元素首次出现的下标。如果元素不存在。 返回的是-1
        int i = strings.indexOf("c");
        System.out.println("strings.get("+i+") = " + strings.get(i));
        System.out.println("strings.indexOf(\"fsadfwa\") = " + strings.indexOf("fsadfwa"));
        //    int lastIndexOf(Object o)： 获取元素最后一次出现的下标。 重后向前找
        strings.add("b");
        System.out.println(strings);
        System.out.println("strings.lastIndexOf(\"b\") = " + strings.lastIndexOf("b"));
        //    ListIterator<E> listIterator()：
        ListIterator<String> stringListIterator = strings.listIterator();
        //    ListIterator<E> listIterator(int index)
//    List<E> subList(int fromIndex, int toIndex)
    }
}
