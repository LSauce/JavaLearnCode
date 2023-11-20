package cn.kiroe.day16_exception._02handle._02trycatch;

/**
 * @author kiro
 * @description:
 * @data 11:34 31/10/2023
 **/
/*

子类异常 一定 要写在父类上面
 */
public class Demo5 {

    public static void main(String[] args) {
        try {
            System.out.println("Start");
            System.out.println(10/0);
            System.out.println("end");
        }catch (ArithmeticException e){
            System.out.println(111);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e){

        }
    }
}
