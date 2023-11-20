package cn.kiroe.day16_exception._02handle._05finally;

/**
 * @author kiro
 * @description:
 * @data 14:59 31/10/2023
 **/
public class Demo2 {

    public static void main(String[] args) {
        try {
            System.out.println("start");
            return;
        }catch (NullPointerException e){
            System.out.println("捕获到了异常");
        } finally {
            System.out.println("一定执行");
        }

        System.out.println("main end");
    }
}
