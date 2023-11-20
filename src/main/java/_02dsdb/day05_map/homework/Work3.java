package _02dsdb.day05_map.homework;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author kiro
 * @description:
 * @data 19:34 14/11/2023
 **/
/*
给定一个整数数组和一个目标值，找出数组中和为目标值的两个数, 返回它们的索引。
你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

比如：nums = [2, 7, 11, 15], target = 9.
因为 nums[0] + nums[1] = 2 + 7 = 9. 所以返回 [0, 1].
 */
public class Work3 {
    public static void main(String[] args) {
        // 两数之和
        // 使用哈希表查询 差值
        int [] nums = {2,7,11,15};
        int target = 9;
        int[] result = getTwoSum(nums,target);
        System.out.println("result = " + Arrays.toString(result));
    }

    private static int[] getTwoSum(int[] nums, int target) {
        if(nums == null){
            return  null;
        }
        int[] result = new int[2];
        // 构建哈希表并查询
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if(map.containsKey(sub)){
                result[0] = map.get(sub);
                result[1] = i;
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }


}
