package cn.kiroe.day16_exception._02handle._05finally;

/**
 * @author kiro
 * @description:
 * @data 14:59 31/10/2023
 **/
/*
finally 个return 不能捕获异常
 */
public class Demo6 {

    public static void main(String[] args) {
        try {
            System.out.println("start");
            test();

            System.out.println(10 / 0);
        } catch (NullPointerException e) {

            System.out.println("捕获到了异常");
        } finally {
            System.out.println("一定执行");
            return; // 程序会跳过给 jvm抛异常
        }


        // System.out.println("main end");
    }
    // 'static' method declared 'final'
    public static final void test(){
        System.out.println("test");
    }
}
