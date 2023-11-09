package cn.kiroe.day23_annotation._6area;

/**
 * @author kiro
 * @description:
 * @data 15:38 8/11/2023
 **/
public class Demo {

    public static void main(String[] args) {
        long l = Runtime.getRuntime().maxMemory();  // 1/4
        long l1 = Runtime.getRuntime().totalMemory();// 1/64
        System.out.println("l = " + l/1024/1024); // l = 1820
        System.out.println("l1 = " + l1/1024/1024); // l1 = 123

    }
}
