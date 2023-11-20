package _02dsdb.day05_map._1introduct;

import java.util.Arrays;
import java.util.Random;

/**
 * @author kiro
 * @description:
 * @data 09:45 14/11/2023
 **/

/*
比如，如果我们想在1-20中间随机生成10000个数，需要记录每个数生成了多少次，怎么存呢？
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] counts = new int[21];
        new Random().nextInt(20);
        for (int i = 0; i < 10000; i++) {
            int random = (int) (Math.random()*20+1);
            counts[random]++;
        }

        System.out.println("counts = " + Arrays.toString(counts));
    }
}
