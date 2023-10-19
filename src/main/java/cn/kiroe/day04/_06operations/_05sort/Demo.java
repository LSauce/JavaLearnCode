package cn.kiroe.day04._06operations._05sort;

import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 10:07 17/10/2023
 **/
public class Demo {
    public static void main(String[] args) {
        //Arrays.sort();
        int[] arr = new int[]{5, 6, 7, 2, 3, 5, 6, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //冒泡排序：
    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }


    }
}
