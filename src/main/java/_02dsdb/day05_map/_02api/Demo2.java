package _02dsdb.day05_map._02api;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author kiro
 * @description:
 * @data 10:28 14/11/2023
 **/
public class Demo2 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"1234");
        map.put(2,"5");
        map.put(3,"4");
        map.put(4,"1234");
        // //---------------------------视图方法
        // // 在Map里面 Entry 代表存储了key和value的一个接口体
        System.out.println(map);
        // //    Set<K> keySet()： 返回此映射中包含的键的 Set 视图。
        // 返回所有健
        System.out.println("map.keySet() = " + map.keySet());
        // //    Collection<V> values()： 返回此映射中包含的值的 Collection 视图。
        System.out.println("map.values() = " + map.values());
        // //    Set<Map.Entry<K,V>> entrySet()： 返回此映射中包含的映射关系的 Set 视图。
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println("map.entrySet() = " + entries);

    }
}
