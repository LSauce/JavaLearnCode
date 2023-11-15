package _02dsdb.day05_map._1introduct;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author kiro
 * @description:
 * @data 09:59 14/11/2023
 **/
public class Demo3 {
    public static void main(String[] args) {
        // 1. Map存储的数据，有一些==子接口有序，有一些无序==
        // HashMap 为存储无序的
        // Map<Integer, String> map = new HashMap<>();
        // LinkedHashMap 是储存有序的
        // Map<Integer, String> map = new LinkedHashMap<>();
        // TreeMap会自动排序，
        Map<Integer, String> map = new TreeMap<>();
        map.put(123,"1");
        map.put(2321,"2");
        map.put(99,"3");
        map.put(4423,"4");
        map.put(51,"5");
        System.out.println("map = " + map); // 自然排序


        // 2. Map存储的数据，不能重复（指的是key）
        // 有重复key，会更新值
        map.put(99,"1");
        System.out.println("map = " + map);
        // 3. Map存储的数据，有一些允许为null，有一些不允许。（指的key）

    }

    @Test
    public void testNull(){
        // HashMap能为key null
        // Map<Integer, String> map = new HashMap<>();
        // LinkedMap能为 null
        // Map<Integer, String> map = new LinkedHashMap<>();
        // TreeMap 不能为 null，因为需要 根据 key进行排序
        //  java.lang.NullPointerException
        Map<Integer, String> map = new TreeMap<>();
        // map.put(null,"12");
        System.out.println("map = " + map);

    }
}
