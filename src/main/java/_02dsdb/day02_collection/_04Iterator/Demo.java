package _02dsdb.day02_collection._04Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author kiro
 * @description:
 * @data 21:20 10/11/2023
 **/
public class Demo {

    public static void main(String[] args) {
        // 测试迭代器
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Iterator<Integer> iterator = integers.iterator();

        iterator.next();
        iterator.remove();
        // System.out.println("iterator = " + iterator);
        System.out.println(integers);
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if(next == 3){
                iterator.remove();
            }
        }
        System.out.println(integers);

    }
}
