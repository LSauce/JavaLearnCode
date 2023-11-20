package cn.kiroe.day16_exception._02handle._05finally;

/**
 * @author kiro
 * @description:
 * @data 14:59 31/10/2023
 **/
/*
finally 和 catch都有个return
 */
public class Demo5 {

    public static void main(String[] args) {
        try {
            System.out.println("start");
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {

            System.out.println("捕获到了异常");
            return;
        } finally {
            System.out.println("一定执行");
            return;

        }

        // System.out.println("main end");
    }
}
