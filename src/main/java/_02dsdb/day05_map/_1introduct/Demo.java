package _02dsdb.day05_map._1introduct;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kiro
 * @description:
 * @data 09:40 14/11/2023
 **/
/*

比如 110 是警察局

120 是医院

119 是火警

122 是车辆救援

12345 是消费者权益保护。用一个键，可以快速获取一个值。
 */
public class Demo {

    public static void main(String[] args) {
        Map<Integer,String> map =new HashMap<>();
        // map中存储的为键值对 数据
        map.put(110,"警察局");
        map.put(120,"医院");
        map.put(119,"火警");
        map.put(122,"车辆救援");
        System.out.println("map = " + map);

        System.out.println("map.get(110) = " + map.get(110));
    }
}
