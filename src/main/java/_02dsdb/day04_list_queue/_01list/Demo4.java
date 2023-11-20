package _02dsdb.day04_list_queue._01list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 10:31 13/11/2023
 **/

/*

//    Object clone()
//    返回此 ArrayList 实例的浅表副本。
//    void ensureCapacity(int minCapacity)
//    如有必要，增加此 ArrayList 实例的容量，以确保它至少能够容纳最小容量参数所指定的元素数。
//    void trimToSize()
//    将此 ArrayList 实例的容量调整为列表的当前大小。
 */
public class Demo4 {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        // 返回此 ArrayList 实例的浅表副本。
        List<Integer> listClone = (List<Integer>) list.clone();
        list.add(10);
        System.out.println("listClone = " + listClone);
        // new Demo4().clone(); // 默认 protected 子类中调用,还要实现Cloneable


        //    void ensureCapacity(int minCapacity)
        //    如有必要，增加此 ArrayList 实例的容量，以确保它至少能够容纳最小容量参数所指定的元素数。
        list.ensureCapacity(1000);

        //    void trimToSize()
        //    将此 ArrayList 实例的容量调整为列表的当前大小。
        list.add(null);
        list.trimToSize();// 使 内部数组大小调整为 刚好为 size大小


        ArrayList<Integer> cloneLists = (ArrayList<Integer>) list.clone();
        System.out.println(cloneLists);

    }
}

class Student{
    String name;

    public Student(String name) {
        this.name = name;
    }
}
