package cn.kiroe.days13_object._04equals._02note;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @author kiro
 * @description:
 * @data 16:40 27/10/2023
 **/

/*

构造方法:
BigDecimal(String val)
将 BigDecimal 的字符串表示形式转换为 BigDecimal。

成员方法:
减法
BigDecimal subtract(BigDecimal subtrahend)
加法:
BigDecimal add(BigDecimal augend)
 */
public class Demo3 {

    public static void main(String[] args) {
        // 1.0-0.9 = 0.1
        // 利用 构造器创建对象
        BigDecimal decimal1 = new BigDecimal("1.0");
        BigDecimal decimal2 = new BigDecimal("0.9");
        //new String().equals()
        System.out.println("decimal2.subtract(decimal2) = " + decimal1.subtract(decimal2));
    }
}
