package cn.kiroe.day14_wrapper._03transfer;

/**
 * @author kiro
 * @description:
 * @data 10:20 28/10/2023
 **/
public class Demo3 {

    public static void main(String[] args) {
        //// 转换为小写
        //static char toLowerCase(char ch)
        //// 转换为大写
        //static char toUpperCase(char ch)
        //// 确定指定字符是否为大写字母
        //static boolean isUpperCase(char ch)
        //// 确定指定字符是否为小写字母
        //static boolean isLowerCase(char ch)
        //// 否为空格
        //static boolean isWhitespace(char ch)
        //// 确定指定字符是否为字母或数字
        //static boolean isLetterOrDigit(char ch)
        //// 确定指定字符是否为字母
        //static boolean isLetter(char ch)
        //// 确定指定字符是否为数字。
        //static boolean isDigit(char ch)


        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);// false 对象地址不一样

        Integer i3 = 1; // 底层使用valueOf(int i)方法
        Integer i4 =1; // 底层使用valueOf(int i)方法
        System.out.println(i3 == i4);// true

        Integer i5 = 1; // 底层使用valueOf(int i)方法
        Integer i6 =1;//底层使用valueOf(int i)方法
        System.out.println(i5 == i6);// true

        /*

        Integer源代码

        Integer中有缓存, low=-128   high=127

        范围-128-127 , 在这个范围内, 返回同一个

        不在范围内, new一个新的对象返回
         */
    }
}
