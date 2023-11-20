package cn.kiroe.day15_string._01introducation;

/**
 * @author kiro
 * @description:
 * @data 09:46 30/10/2023
 **/
/*
String 构造方法

    byte[] --> String
    char[] --> String
 */
public class Demo {
    public static void main(String[] args) {
        //   //空字符串 ""
        //  public String()
        String s = new String();
        System.out.println("s = " + s);
        //  //利用字节数组，创建字节数组所表示的字符串
        //  // 1. 字符 -> 数值形式  'a' -> 97
        //  // 2. 所以可以用多个字节值，表示多个字符——>即字符序列 public
        //  String(byte[] bytes)
        byte[] bytes = {97, 98, 99, 100};
        String s1 = new String(bytes);
        System.out.println("s1 = " + s1);

        //  //利用字节数数组的一部分，创建字符序列, 从byte数组的offset开始的length个字节值
        //  public String(byte[] bytes,int offset,int length)
        String s2 = new String(bytes,0,2);
        System.out.println("s2 = " + s2);
        //  //利用一个字符数组创建字符数组，代表的字符序列
        //  public String(char[] value)
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String s3 = new String(chars);
        System.out.println("s3 = " + s3);

        char[] chars1 = {'h','e','l'};
        String s4 = new String(chars,0,2);
        System.out.println("s4 = " + s4);

        //  // 创建value字符数组中，从第offset位置开始的count个字符，所代表的字符串对象
        //  public String(char[] value,int offset,int count)
        //
        //  //知道即可
        //  public String(String original)
        String zs = new String("zs");
        System.out.println("zs = " + zs);

        String s5 = new String("aaa");

    }
}
