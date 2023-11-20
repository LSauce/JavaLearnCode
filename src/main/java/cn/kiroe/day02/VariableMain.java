package cn.kiroe.day02;
/*
* 分类：
*   1.基本数据类型:
*       4类8种：
*       整型：
*           byte:   1B=8bit 0000 0000          [-128,127]   [- 2^7, 2^7-1]
*           short:  2B  0000 0000 0000 0000    [-32768,32767] [-2^15, 2^15-1 ]
*           int:    4B  0000 0000 0000 0000 0000 0000 0000 0000
*           long:   8B
*       浮点型：
*           float:  单精度 32位
*           double: 双精度 64位
*       字符型：
*       字符类型:
*           char: 2B [0,65535]
*       布尔：
    2. 引用数据类型：
        除基本类型，其他都为引用
        class、interface、...、String
 *
* */
public class VariableMain {
    public static void main(String[] args) {

        // 整型:
        byte b = 1;
        short s= 1;
        int i = 1;
        long l = 1;

        //浮点：
        float f = 3.14f;
        double d= 3.14;

        //字符类型：
        char c= 'c';

        //布尔：
        boolean bool = true;

        //引用数据类型:
        String s1 = "s1";
        String s2 = "s2";

        //字符 映射测试：
        charTest();
        //  变量测试
        variableTest();

    }

    public static void charTest(){
        char c = 'a';
        System.out.println(c);
    }


    public static void stringTest() {

        String s1 = "abc";
        String s2 = "abcd";
        System.out.println(s1.equals(s2));
    }

    /*
    * 常量：
    *   字面值常量：
    *       1. 整数 2
    *       2. 小数 1.1
    *       3. 字符 '1'
    *       4. 布尔 true
    *       5. 字符串 "s"
    *       6. 空常量 null
    *   自定义常量:
    *       被final修饰的变量
    *
    * */

    /*
    * 变量：
    *   局部变量：
    *       定义在局部位置(方法内,代码块内，不算类代码块)的变量
    *      只在作用域内生效
    * */
    public static void variableTest(){
        //局部变量
        //局部位置

        int a = 1;
        {
            int b = 1;
            System.out.println(b);
        }

        {
            int b = 1;
            System.out.println(b);
        }
        /*
        //不能再if 判断中定义变量
        if(boolean a = true){

        }

         */
        /*
        //局部变量的使用
            1.声明
                数据类型 变量名；
            2.初始化
                给变量赋值(=)

         */
        //延迟初始化
        int i;
        i = 10;
        //声明 初始化
        int i2 = 12;
        //注意事项：
        /*
        * 细节：
        *   1. java整数 字面量值 常量 ，默认使用int
        *   2. long 赋值需要再 常量后加L(小写l 可能看不清误读)
        *   3. 浮点 字面值 常量，默认 使用double, 可使用 加f 指定
        *   4. 规范 最好 一行定义一个变量
        * */


        System.out.println(10/3.0);//3.3333333333333335
        System.out.println(1-0.9);
        //0.1 ---> 0b 0.1

        /*
        *  0.1 *2 = 0.2 *2 = 0.4*2 = 0.8*2 = 1.6 *2 = 1.2 *2 = 0.4
        *           0       0       0       1        1        0
        *
        * 近似值
        * */
        //000110011
    }
}
