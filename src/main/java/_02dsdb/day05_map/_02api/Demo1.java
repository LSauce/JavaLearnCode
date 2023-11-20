package _02dsdb.day05_map._02api;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author kiro
 * @description:
 * @data 10:10 14/11/2023
 **/
/*
//---------------------------新增，删除，查找数据接口
//    V put(K key, V value): 添加键值对。 如果键存在，是更新数据
//    void putAll(Map<? extends K,? extends V> m)： 将一个map的所有键值对都放入这个map
//    V get(Object key)： 根据一个key，获取value，如果key不存在，返回null
//    V remove(Object key)： 删除map中所包含的这个key

//    boolean containsKey(Object key): 判断map中是否包含这个key
//    boolean containsValue(Object value): 判断map中是否包含这个value

//---------------------------辅助接口
//    void clear() : 清空map
//    boolean equals(Object o)： 判断两个map是否相等
//    int hashCode(): 返回此映射的哈希码值。
//    boolean isEmpty(): map中是否有元素
//    int size() ：返回键-值映射关系数。

//---------------------------视图方法
// 在Map里面 Entry 代表存储了key和value的一个接口体
//    Set<Map.Entry<K,V>> entrySet()： 返回此映射中包含的映射关系的 Set 视图。
//    Set<K> keySet()： 返回此映射中包含的键的 Set 视图。
//    Collection<V> values()： 返回此映射中包含的值的 Collection 视图。
 */

public class Demo1 {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        //---------------------------新增，删除，查找数据接口
        //    V put(K key, V value): 添加键值对。 如果键存在，是更新数据
        map.put(1,"1234");
        map.put(2,"5");
        map.put(3,"4");
        map.put(4,"1234");
        // put方法是增加 方法也是，修改方法，
        // 如果健存在则 更新值
        System.out.println(map);
        map.put(2,"changed");
        System.out.println(map);
        //    void putAll(Map<? extends K,? extends V> m)： 将一个map的所有键值对都放入这个map
        HashMap<Integer, String> mapPutAll = new HashMap<>();
        mapPutAll.put(77,"test");
        map.putAll(mapPutAll);
        System.out.println(map);
        //    V get(Object key)： 根据一个key，获取value，如果key不存在，返回null
        System.out.println("map.get(1) = " + map.get(1));
        //    V remove(Object key)： 删除map中所包含的这个key
        // 删除时 无该 key返回 null
        System.out.println("map.remove(2) = " + map.remove(66));
        //    boolean containsKey(Object key): 判断map中是否包含这个key
        System.out.println("map.containsKey(1) = " + map.containsKey(2));
        //    boolean containsValue(Object value): 判断map中是否包含这个value
        System.out.println("map.containsValue(\"test\") = " + map.containsValue("2"));
        // getOrDefault(Object key, V defaultValue) 当key中不存在时，返回 默认值
        System.out.println("map.getOrDefault(1,\"没有这个值\") = " + map.getOrDefault(1, "没有这个值"));
    }

    @Test
    public void auxiliaryApiTest(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"1234");
        map.put(2,"5");
        map.put(3,"4");
        map.put(4,"1234");
        // //---------------------------辅助接口
        // //    void clear() : 清空map
        map.clear();
        // //    boolean equals(Object o)： 判断两个map是否相等
        // 比较 hashCode，hashCode 由内部数据决定
        System.out.println("map.equals(map) = " + map.equals(new HashMap<>()));
        // //    int hashCode(): 返回此映射的哈希码值。
        System.out.println("map.hashCode() = " + map.hashCode());
        // //    boolean isEmpty(): map中是否有元素
        System.out.println("map.isEmpty() = " + map.isEmpty());
        // //    int size() ：返回键-值映射关系数。
        System.out.println("map.size() = " + map.size());
    }


}
