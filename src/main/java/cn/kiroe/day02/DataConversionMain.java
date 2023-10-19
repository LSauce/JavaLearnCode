package cn.kiroe.day02;
/*
1.自动类型转换
    自动发生的，不需要写额外的代码
    小范围 --> 大范围
2.强制类型转换
    需要二外的代码
    大范围 --> 小范围
 */
public class DataConversionMain {
    public static void main(String[] args) {
        // 自动类型转
        byte a = 1;
        int a1 = a;
        System.out.println(a1);
    }
}
