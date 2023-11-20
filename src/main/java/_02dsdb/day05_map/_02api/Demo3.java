package _02dsdb.day05_map._02api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kiro
 * @description:
 * @data 10:34 14/11/2023
 **/
/*
map中 想获取值和键
1. entrySet
2. keySet()   get()
3. 获取键 values();
 */
public class Demo3 {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"1234");
        map.put(2,"5");
        map.put(3,"4");
        map.put(4,"1234");

        for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {
            System.out.println("integerStringEntry = " + integerStringEntry);
        }
    }
}
