package _02dsdb.day06_map.linkedhashmap;

import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * @author kiro
 * @description:
 * @data 10:18 15/11/2023
 **/
public class Demo1 {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        // put没有重写 用的 HashMap的 put
        // 但重写的 newNode 方法，在newNode的时候 连接链表
        // 妙啊
        map.put(1, 1);
        map.put(2341234, 2);
        map.put(3, 3);
        map.put(44234, 4);
        map.put(51, 5);
        /// LinkedHashMap 就是 遍历有序，为 HashMap的一个子类
        System.out.println("map = " + map);
        map.get(12);
    }

    @Test
    public void constructTest() {
        // LinkedHashMap()
        // 构造一个带默认初始容量 (16) 和加载因子 (0.75) 的空插入顺序 LinkedHashMap 实例。
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        // LinkedHashMap(int initialCapacity)
        //           构造一个带指定初始容量和默认加载因子 (0.75) 的空插入顺序 LinkedHashMap 实例。
        LinkedHashMap<Integer, Integer> map2 = new LinkedHashMap<>(17);
        // 这里的17 对应 实机元素的个数，不是数组的长度
        // LinkedHashMap(int initialCapacity, float loadFactor)
        //           构造一个带指定初始容量和加载因子的空插入顺序 LinkedHashMap 实例。
        // LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
        //           构造一个带指定初始容量、加载因子和排序模式的空 LinkedHashMap 实例。
        // LinkedHashMap(Map<? extends K,? extends V> m)
        //           构造一个映射关系与指定映射相同的插入顺序 LinkedHashMap 实例。
        map.get(0);
    }
}
