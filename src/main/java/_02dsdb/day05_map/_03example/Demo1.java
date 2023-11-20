package _02dsdb.day05_map._03example;

import java.util.HashMap;

/**
 * @author kiro
 * @description:
 * @data 10:38 14/11/2023
 **/

/*
1-10_000_000中间生成1000次？
 */
public class Demo1 {

    public static void main(String[] args) {
        // /*
        // 1-10_000_000中间生成1000次？
        //  */
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            int randomNum =  getRandom(1,10_000_000);
            Integer count = countMap.getOrDefault(randomNum, 0);
            countMap.put(randomNum ,count + 1); // 获取前值后加1
            /*if(countMap.containsKey(i)){
                Integer count = countMap.get(randomNum) +1;
                countMap.put(randomNum,count);
            }else{
                countMap.put(randomNum,1);
            }*/
        }
        System.out.println(countMap);
    }

    public static int getRandom(int start, int end) {
        return (int) (Math.random() * (end - start) + 1);
    }
}
