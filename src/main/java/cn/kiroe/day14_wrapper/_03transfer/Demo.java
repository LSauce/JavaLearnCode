package cn.kiroe.day14_wrapper._03transfer;

/**
 * @author kiro
 * @description:
 * @data 10:09 28/10/2023
 **/
public class Demo {
    public static void main(String[] args) {
        //包装类型和String类型的相互转换

        // wrapper----> String
        Integer integer = 2; // 自动装箱
        // 方式一: 使用toString方法
        String s1 = integer.toString();
        System.out.println("s1 = " + s1);

        // 方式二: 字符串拼接
        String s2 = "" + integer;
        System.out.println("s2 = " + s2);

        // 方式三: 使用String里的api: valueOf(int i)
        String s3 = String.valueOf(integer);
        System.out.println("s3 = " + s3);
    }
}
