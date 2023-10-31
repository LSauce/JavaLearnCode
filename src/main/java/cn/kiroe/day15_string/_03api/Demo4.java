package cn.kiroe.day15_string._03api;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 14:59 30/10/2023
 **/
/*

其他功能
 */
public class Demo4 {

    public static void main(String[] args) {

        //
        //            String类的替换功能
        //在新的字符串中，用新(new)字符，替换旧(old)字符  "abcd"
        //String replace(char old,char new)
        System.out.println("\"abcdcccccccc\".replace('c','f') = " + "abcdcccccccc".replace('c', 'f'));
        //在新的字符串中，用新的字符串(new), 替换旧(old)字符串
        //String replace(String old, String new)
        System.out.println("\"fackfackfffffffffack\".replace(\"fack\",\"google\") = " + "fackfackfffffffffack".replace("fack", "google"));
        //
        //在新的字符串中，去掉开头和结尾的空格字符 "abc"  "abc "
        //String trim()
        System.out.println("\"   fff  fdsaf       \".trim() = " + "fff  fdsaf       ".trim());
        //分隔功能
        //将字符串按照符号分隔成字符串数组  "a,b,c,d"
        //String[] split(String re)
        System.out.println("\"a,b,c,d,f,g,h\".split(\",\") = " +
                Arrays.toString("a,b,c,d,f,g,h".split(",")));
        //String类的比较功能
        //int compareTo(String str)
        System.out.println("\"abcdf123\".compareTo(\"abcdf2\") = "
                + "abcdf123".compareTo("abcdf2"));
        //int compareToIgnoreCase(String str)
        System.out.println("\"abcdEfg1\".compareToIgnoreCase(\"abcdefg2\") = " +
                "abcdEfg1".compareToIgnoreCase("abcdefg1"));
        //

        System.out.println("\"abcdefg\".compareTo(\"abcdefg\") = " + "abcdefg".compareTo("abcdefg"));

    }
}
