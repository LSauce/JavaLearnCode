package cn.kiroe.day09._01extends._05final._03variable._03static;

/**
 * @author kiro
 * @description:
 * @data 17:15 23/10/2023
 **/
public class Demo2 {
    public static void main(String[] args) {
        // 不是完整的类加载
        System.out.println("Test.a = " + Test.a);
        byte num1 = 0;
        byte num2 = 0;
        final int num3 = 10;
        final int num4 = 20;
        byte result;
        // 下列代码哪行能通过编译，哪行不能？
        result =  (byte) (num1 + num2); // int 转换 byte
        result = num3 + num4;// 可以 == byte b= 1+2, 相当于 常量
        result = (byte) (num1 + num3);// 不能

        final Student2 s = new Student2();
        // s = new Student();
        // s.age = 18;
    }

    public int test(final int a){
        //return a++;
        return a+1;
    }
}

class Student2{
    int age;
    public Student2() {
    }
}

class Test{
    final static int a = 100;
    static {
        System.out.println("static");
    }
}
