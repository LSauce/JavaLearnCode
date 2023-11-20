package cn.kiroe.day04._04use;

import java.util.Arrays;

/*

数组基本操作
 */
public class Demo {


    public static void main(String[] args) {
        //1.打印数组名
        int[] a ={1,2,3};
        int[] a2 ={1,2,3};
        System.out.println(a);
        // [I@232204a1
        // [ 一维数组
        // I int类型数值
        // @固定值
        // 232204a1 地址值
        //Arrays 工具类
        String s = Arrays.toString(a);
        System.out.println(s);

        // 访问数组元素
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);

        //修改元素
        a[0] = 5;
        a[1] = 6;
        a[2] = 7;
        //获取长度
        System.out.println(a.length);

    }
}
