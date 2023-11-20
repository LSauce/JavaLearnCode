package cn.kiroe.day04.array;

public class Main {

    public static void main(String[] args) {
        //说明数值:
        //1. 建议使用
        int[] arr1;
        //2. c中方法
        int arr2[];

        // 初始化
        // 静态初始化：
        int[] arr3 = new int[]{1,2,3,4,5};
        int[] arr4 = {1,2,3,4};
        //动态初始化: 默认值为0,boolean为false，引用类型为 null
        int[] arr5 = new int[5];

        //错误写法：两种不能混合，
        // int[] arr6 = new int[5]{1,2,3,5};
        int[] arr6 = new int[]{1,2,3,5};// 需删除5

        //动态初始化默认值,string 默认值为null
        String[] arr7 = new String[2];

    }
}
