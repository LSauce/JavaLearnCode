package cn.kiroe.day03.method;

import java.util.Scanner;

public class EscapeMain {
    public static void main(String[] args) {
        String[] escape = {"Escape character","fffffffff",
                "ffff\bfffff",
                "ffff\nfffff",
                "ffff\rfffff",
                "ffff\tfffff",
                "ffff\\fffff",
                "ffff\'fffff",
                "ffff\"fffff",
                "ffff\u0000fffff",

        };
        for (String e: escape){
            System.out.println(e);
        }
        System.out.println();
    }
}

class Demo {

    public static void main(String[] args) {
        int a =  10;
        int b  = 20;
        int c;
        c = a + b;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num > 0) {
            System.out.println("你输入的数大于0");
        } else if (num == 0) {
            System.out.println("你输入的数等于0");
        } else {
            System.out.println("你输入的数小于0");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        method();
    }
    public static void method() {
        System.out.println("test");
        System.out.println("test");
        System.out.println("test");
        System.out.println("test");
    }
}
