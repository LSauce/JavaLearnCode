package cn.kiroe.day06.oop1.homework;

import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 19:24 17/10/2023
 **/
public class ArrayExercise {
    /*
    数组综合练习——真正删除元素
对于某个String类型数组（数组中不考虑存在null元素），将其中的某个元素全部去掉，得到一个新数组，并统计去掉了几个元素。

举例，对于String数组["abc", "123", "123", "123", "666", "777"] 将其中的元素"123"全部去掉，就得到了新数组["abc","666", "777"]，一共去掉了3个元素。

注：

这里说的去掉，不是指用0/null等默认值替代原先的元素，而是指真正的删除掉。

思考：
1.同一个数组能不能实现这个功能？如果不能，应该怎么完成呢？
答：在同一个数值无法实现，数组长度无法改变
    只能再new一个更短的数组
2.String如何判断内容相同?
使用equals()判断
     */

    public static void main(String[] args) {
        // 对于某个String类型数组（数组中不考虑存在null元素），
        // 将其中的某个元素全部去掉，
        // 得到一个新数组，
        // 并统计去掉了几个元素。
        String[] arr = new String[]{"1", "2", "3", "4", "4", "4", "-111"};
        System.out.println(Arrays.toString(delElement(arr, "4"))); // [1, 2, 3, -111]

    }

    public static String[] delElement(String[] arr, String value) {
        String[] result = null;
        int count = 0;
        if (arr != null && value != null) {
            for (int i = 0; i < arr.length; i++) {
                if (value.equals(arr[i])) {
                    count++;
                }
            }
            result = new String[arr.length - count];
            int j = 0;
            for (int i = 0; i < arr.length; i++) {
                if (!value.equals(arr[i])) {
                    result[j] = arr[i];
                    j++;
                }
            }
        }
        return result;

    }
}



