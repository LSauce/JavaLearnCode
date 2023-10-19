package cn.kiroe.day04._06operations._01traverse;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo {
    /*
    数组遍历：
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        traversel(arr);
        Arrays.toString(arr);
        // System.out.println(getMax(arr));
        System.out.println(Arrays.toString(reveser(arr)));
        System.out.println(Arrays.toString(reveser2(arr)));
    }

    public static int getMax(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int max = arr[0];
        for (int j : arr) {
            if (max < j) {
                max = j;
            }
        }

        return max;

    }

    public static void traversel(int[] arr) {
        //for
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }
    /*
    @NotNull
    public static int[] test(int[] arr){
        return  arr;
    }
    返回值不为Null？
     */

    //数组反转：
    public static int[] reveser(int[] arr) {
        if (arr == null) {
            return arr;
        }
        //左闭右闭
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }


        return arr;
    }

    public static int[] reveser2(int[] arr) {
        if (arr == null) {
            return arr;
        }
        int l = 0;
        int r = arr.length - 1;

        //循环结束,不一定重合，为偶数时可能直接错过
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return arr;
    }
}
