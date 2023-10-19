package cn.kiroe.day06.oop1.homework;

/**
 * @author kiro
 * @description:
 * @data 19:51 17/10/2023
 **/
public class VariableParameterExercise {
    /*

    可变参数练习
可变参数的本质是数组，完成下列需求：

求不限定个数参数的最大值（要求使用可变参数，使用int类型即可）

注：纯粹语法练习,可变参数直接当数组处理即可.
     */

    public static int getMax(int... nums) {
        int max = -1;

        if (nums != null && nums.length > 0) {
            max = nums[0];
            for (int num : nums) {
                if (max < num) {
                    max = num;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 7, 8, 5, 5, 3};
        System.out.println("getMax(nums) = " + getMax(nums));
        System.out.println("getMax(1,2,4,5,64,3,3) = " + getMax(1, 2, 4, 5, 64, 3, 3));
    }
}
