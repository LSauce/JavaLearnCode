package cn.kiroe.day14_wrapper._03transfer;

/**
 * @author kiro
 * @description:
 * @data 10:15 28/10/2023
 **/
public class Demo2 {
    // **String--->包装类**
    public static void main(String[] args) {
        // String ---> wrapper
        String s = "1";
    // 方式一: parseInt(int i)
        Integer integer1 = Integer.parseInt(s); // 自动装箱
        System.out.println("integer = " + integer1);
    // 方式二: valueOf(String s)
        Integer integer2 = Integer.valueOf(s);
        System.out.println("i1 = " + integer2);
    // 方式三: 使用Integer的构造方法
        Integer integer3 = new Integer(s);
        System.out.println("integer2 = " + integer3);
    }
}
