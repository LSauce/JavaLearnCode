package cn.kiroe.day15_string.homework;

/**
 * @author kiro
 * @description:
 * @data 19:20 30/10/2023
 **/
public class Test {

    public static void main(String[] args) {

        System.out.println(("aaa".intern().hashCode()));
        System.out.println("(Integer.MAX_VALUE +1) = " + (Integer.MAX_VALUE + 1));
        System.out.println("(Integer.MAX_VALUE +1) = " + (Integer.MIN_VALUE));
        System.out.println("(Integer.MAX_VALUE +1) = " + (Byte.MAX_VALUE+1));

        byte b = (byte) (Byte.MAX_VALUE +1);
        System.out.println("b = " + b);

        System.out.println("Integer.parseInt(\"aaa1\") = " + Integer.parseInt("111"));
        Integer integer = new Integer(1);
        integer.hashCode();


    }
}
