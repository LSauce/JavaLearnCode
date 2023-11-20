package cn.kiroe.day15_string._05stringbuffer._2basic;


/**
 * @author kiro
 * @description:
 * @data 17:21 30/10/2023
 **/

/*

String --> StringBuffer
 */
public class Demo3 {
    public static void main(String[] args) {
        String s = "abc";
        //利用构造方法
        StringBuilder sb = new StringBuilder(s);
        System.out.println("sb = " + sb);
        //sb --> String
        String a = sb.toString();
        System.out.println("a = " + a);
        "test".intern();
        System.out.println("s.equals(sb.toString()) = " + s.equals(sb.toString()));
    }

}


class Demo4{

    public static void main(String[] args) {

    }
}

