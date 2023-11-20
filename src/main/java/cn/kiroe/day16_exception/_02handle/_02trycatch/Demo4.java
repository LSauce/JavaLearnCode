package cn.kiroe.day16_exception._02handle._02trycatch;

/**
 * @author kiro
 * @description:
 * @data 11:28 31/10/2023
 **/
/*
try{
   // 可能出现异常的代码
}catch(异常类型 对象名){
   // 对异常的处理操作
}catch(异常类型 对象名){
   // 对异常的处理操作
}catch(异常类型 对象名){
   // 对异常的处理操作
}.....
 */
public class Demo4 {

    public static void main(String[] args) {
        try {
            System.out.println("Start");
            System.out.println(10/0);
            System.out.println("end");
        } catch (NullPointerException e) {
            // throw new RuntimeException(e);
            System.out.println("捕获到了空指针异常");
        } catch (ArithmeticException e){
            System.out.println("捕获到算数异常");
        } catch (ArrayIndexOutOfBoundsException  e){
            System.out.println("捕获到了 数组越界");
        }

    }
}
