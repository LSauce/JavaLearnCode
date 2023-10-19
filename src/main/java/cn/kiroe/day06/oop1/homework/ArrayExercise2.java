package cn.kiroe.day06.oop1.homework;

import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 20:04 17/10/2023
 **/
public class ArrayExercise2 {
    /*

    首先准备两个数组（简单起见，用两个普通int数组即可）将这两个数组合并。

所谓合并就是将两个数组中的元素合并成一个新数组。

比如对于数组1[1,2,3]和数组2[2,2,2]

合并的结果是新数组[1,2,3,2,2,2]



注：

数组合并也是很常见的操作，实际开发中有很多现成的手段去完成它。由于有些手段是超纲的，所以这里不再细表。

如果后续工作中碰到了，可以再百度学习一下。目前就先考虑自己手写实现就可以了。
     */

    public static void main(String[] args) {
        //首先准备两个数组（简单起见，用两个普通int数组即可）将这两个数组合并。

        //所谓合并就是将两个数组中的元素合并成一个新数组。

        // 比如对于数组1[1,2,3]和数组2[2,2,2]

        //合并的结果是新数组[1,2,3,2,2,2]

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 2, 2};
        System.out.println("Arrays.toString(mergeArray(arr1,arr2)) = " + Arrays.toString(mergeArray(arr1, arr2)));
    }

    public static int[] mergeArray(int[] arr1, int[] arr2) {
        int[] result = null;
        if (arr1 != null && arr2 != null) {
            result = new int[arr1.length + arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                result[i] = arr1[i];
            }

            for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
                result[i] = arr2[i - arr1.length];
            }
        }
        return result;
    }
}
