package cn.kiroe.day04._04use;

import java.util.Arrays;

public class Demo5 {
    public static void main(String[] args) {
        //静态初始化,长度为0的数组
        int[] arr = new int[0];
        System.out.println(arr);
        System.out.println(arr.length);

        System.out.println(Arrays.toString(getResult(-1)));
    }

    //长度为0数组的使用：
    /*
        更具输入的值n返回不同的结果
        n>0 返回一个结果
        n==0 返回两个结果
        n<0 返回0个结果
     */
    public static int[] getResult(int n) {
        int[] result = new int[0];

        if (n > 0) {
            result = new int[]{1};
        } else if (n == 0) {
            result = new int[]{1, 2};
        }
        return result;
    }

}
