package cn.kiroe.day06.oop1.homework;

/**
 * @author kiro
 * @description:
 * @data 19:38 17/10/2023
 **/
public class ValueTransfer {
    /*

    值传递练习
Java有且仅有值传递，Java中的方法不能直接改变实参本身。

对于下列代码：
*/
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        method(a, b);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }
    /*
    上述main方法不变，修改method方法实现，让程序输出：

    a = 20
    b = 40
    如何实现呢？
     */
    public static void method(int a, int b) {

        System.out.println("a = " + 20);
        System.out.println("b = " + 40);

    }

    /*
思考以下问题：

对于以上Java代码，method()方法可以把a，b的取值变为原先的2倍吗？如果不能，为什么？
答： 不能， java为值传递，只传递了值，并无变量地址，故不能改变
上述main方法不变，修改method方法实现，让程序输出：

a = 20

b = 40

如何实现呢？

注：这是个脑筋急转弯，不会的可以互相问问或者查一查百度吧。

     */



}
