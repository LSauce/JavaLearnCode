package cn.kiroe.day16_file.homework.ex3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 19:39 31/10/2023
 **/
/*

Scanner进行键盘录入时，非常容易产生异常，那么就有必要进行异常处理。

我们在进行键盘录入操作时，有时需要把录入的一个字符串转换成int数字。
但如果输入的字符串并不是一个数字时，显然是不能转换成功的，
而是会抛出一个异常NumberFormatException。

要求：
处理该异常，让程序不会报错终止，而是让用户重新输入，直到输入正确的数字为止
 */
public class ExceptionTest {

    public static void main(String[] args) {
        System.out.println("请输入一个数字:");
        Integer input;
        while ( (input = inputInt()) == null ){
            System.out.println("请输入的值为整数，请再输入");

        }
        System.out.println("您输入的为："+ input);



    }

    public static Integer inputInt() {


        try {
            Scanner scanner = new Scanner(System.in);
            Integer a = Integer.valueOf(scanner.nextLine());
            return a;
        } catch (NumberFormatException | InputMismatchException e) {
            return null;
        }
    }


}
