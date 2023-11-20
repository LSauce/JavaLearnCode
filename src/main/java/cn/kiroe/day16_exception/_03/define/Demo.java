package cn.kiroe.day16_exception._03.define;

import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 15:14 31/10/2023
 **/
public class Demo {

    public static void main(String[] args)  {

        Scanner  scanner = new Scanner(System.in);
        System.out.println("请输入一个分数(0-100)");
        int score = scanner.nextInt();
        try {
            input(score);
        } catch (MyException2 e) {
            e.printStackTrace();
        }catch (NullPointerException e){

        }


    }

    private static void input(int score) throws MyException2 {
        if(score < 0 || score > 100){
            // 抛出异常
            // throw + 异常对象
            // throw new MyException("成绩需要再 0-100之间");
            throw new MyException2("成绩有问题");

        }
    }
}

class MyException extends RuntimeException{

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}


class MyException2 extends Exception{
    public MyException2(){

    }

    public MyException2(String message) {
        super(message);
    }
}
