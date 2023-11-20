package cn.kiroe.day15_string._03api;

/**
 * @author kiro
 * @description:
 * @data 11:26 30/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
//        用来比较字符串的内容，注意区分大小写
//        boolean equals(Object obj)

//
//        忽略字符串大小写比较字符串内容，常见用于比较网址URL
//        boolean equalsIgnoreCase(String str)

//        判断当前字符串对象是否包含，目标字符串的字符序列
//        boolean contains(String str)
        System.out.println("\"abc\".contains(\"ab\") = " + "abc".contains("ab"));
//        判断当前字符串对象，是否已目标字符串的字符序列开头
//        boolean startsWith(String str)
        System.out.println("\"abc\".startsWith(\"ab\") = " + "abc".startsWith("ab"));
//        判断当前字符串，是否以目标字符串对象的字符序列结尾，常用于确定文件后缀名格式
//        boolean endsWith(String str)
        System.out.println("\"abc\".endsWith(\"bc\") = " + "abc".endsWith("bc"));
//        判断一个字符串，是不是空字符串
//        boolean isEmpty()
        System.out.println("\"abc\".isEmpty() = " + "abc".isEmpty());
        System.out.println("\"\".isEmpty() = " + "".isEmpty());
    }
}
