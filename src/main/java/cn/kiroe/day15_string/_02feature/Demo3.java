package cn.kiroe.day15_string._02feature;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 10:19 30/10/2023
 **/
/*

- 直接赋值 String s = "abc"
- 构造方法 String s = new String("abc")
 */
public class Demo3 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println("s1==s2 = " + s1 == s2);

        char[] arr = new char[]{'a', 'b', 'c'};
        //String s3 = new String(arr, true);
        arr[0] = '2';
        //System.out.println("s3 = " + s3);
        char[] cs = {'1', '2', '3', '4'};
        PrivateTest privateTest = new PrivateTest(cs);
        cs[0] = 'a';
        System.out.println("Arrays.toString(cs) = " + Arrays.toString(cs));
        System.out.println("Arrays.toString(privateTest.getCs()) = " + Arrays.toString(privateTest.getCs()));

        PrivateTest privateTest1 = new PrivateTest(privateTest);
        System.out.println("Arrays.toString( privateTest1.getCs()) = " + Arrays.toString(privateTest1.getCs()));




    }

}


class PrivateTest {

    private char[] cs;

    public PrivateTest(char[] cs) {
        this.cs = cs;
    }

    public PrivateTest(PrivateTest privateTest) {
        this.cs = privateTest.cs; // 没有权限问题,可调用同类 对象private 方法
    }

    public char[] getCs() {
        return cs;
    }
}
