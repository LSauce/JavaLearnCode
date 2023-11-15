package _02dsdb.day02_collection.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author kiro
 * @description:
 * @data 10:51 11/11/2023
 **/
public class Test2 {

    public static void main(String[] args) {
        int count = 0 ;
        count  = 233;
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        final int finalCount = count;
        integers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("count = " + finalCount);// 会默认给你 在变量前加 final
            }
        });

    }
}
