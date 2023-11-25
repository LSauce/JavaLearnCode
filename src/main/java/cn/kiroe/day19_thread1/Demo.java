package cn.kiroe.day19_thread1;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author kiro
 * @description:
 * @data 10:58 3/11/2023
 **/
/*
假如我要实现如下功能
程序不停地在屏幕上输出一句问候的语句(比如“你好”)
“同时”，当我通过键盘输入固定输入的时候，程序停止向屏幕输出问候的语句(比如说输入gun)

 */
public class Demo {

    public static boolean flag = true;
    public static void main(String[] args) {
        first();
        //second2();

    }

    private static void second2() {
        System.out.println("main before");
        System.out.println("hello before");

        new Thread(Demo::sayHello).start();
        System.out.println("hello after");


        System.out.println("wait before");
        waitToStop();
        System.out.println("wait after");


        System.out.println("main after");
    }

    private static void waitToStop() {
        Scanner scanner = new Scanner(System.in);
        // 多次输入
        while (flag) {
            String s = scanner.nextLine();
            if ("gun".equals(s)) {
                flag = false;
                break;
            }
        }
    }

    private static void sayHello() {
        while (flag) {
            System.out.println("你好");
            try {
                // 让程序暂停执行3秒
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void first() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("不停的输入你好");
        Thread thread =  new Thread(()-> sayHello());

        thread.setDaemon(true);
        thread.start();
        while (flag){
            System.out.println("输入 gun 暂停");
            if(flag = !"gun".equals(scanner.nextLine())){
                System.out.println("要停止了");
            }
        }
        String s = "ff";
        char[] chars = s.toCharArray();
        // 匿名内部类 使用外部非静态变量，只能使用 常量
        char[] finalChars = chars;
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                finalChars[0] = 233;
                finalChars[1] = 2342;

            }
        });
        chars = "ff".toCharArray();
        thread2.start();
    }
}
