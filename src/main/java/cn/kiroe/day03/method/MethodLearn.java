package cn.kiroe.day03.method;


import java.util.Scanner;
import java.util.Stack;

public class MethodLearn {
    public static void main(String[] args) {
        showAdd();
        System.out.println(max(1, 2));
        getTwoMax();
        System.out.println(isEven(20));
    }

    /*

    1. 编写程序，计算10+20，并输出结果
2. 编写程序，计算111+222，并输出结果
3. 编写程序，计算333+444，并输出结果
     */
    public static void showAdd() {
        System.out.println(10 + 20);
        System.out.println(111 + 222);
        System.out.println(333 + 444);
    }
    /*
    1. 求两个数的最大值。
2. 键盘录入两个值，求最大值。
3. 定义一个方法用于判断一个正整数的奇偶性，要求：
   1. 奇数方法返回false
   2. 偶数方法返回true
4. 定义一个计算器（Calculator）它的功能有：
   1. 加，减，乘，除
   2. 求平方
   3. 求a的n次方
   4. ...
5. 定义一个方法，求圆的面积：
   1. 方法参数:半径 (radius)
   2. 圆周率:3.14（获取用Math.PI获取）
     */

    //    1. 求两个数的最大值。
    public static double max(double n1, double n2) {
        return n1 > n2 ? n1 : n2;
    }

    //2. 键盘录入两个值，求最大值。
    public static void getTwoMax() {
        Scanner in = new Scanner(System.in);
        System.out.println("--键盘录入两个值，求最大值--");
        System.out.print("请输入两个值");
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        System.out.println("最大值为：" + max(n1, n2));
    }

    /*  3. 定义一个方法用于判断一个正整数的奇偶性，要求：
              1. 奇数方法返回false
              2. 偶数方法返回true*/
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }


}

/*
    4. 定义一个计算器（Calculator）它的功能有：
            1. 加，减，乘，除
            2. 求平方
            3. 求a的n次方
     */
class Calculator {
    public static void main(String[] args) {
    }

    //1.1 加
    public static double add(int n1, int n2) {
        return n1 + n2;
    }

    //1.2 减
    public static double sub(double n1, double n2) {
        return n1 - n2;
    }

    //1.3 乘
    public static double mul(double n1, double n2) {
        return n1 - n2;
    }

    //1.4 除
    public static double div(double n1, double n2) {
        return (double) n1 / n2;
    }

    //2. 求平方
    public static double square(double n1) {
        return n1 * n1;
    }

    //3. 求n的次方
    public static double pow(double a, double n) {
        return Math.pow(a, n);
    }

}


    /*
    小试牛刀：

1. 使用方法重载，控制台输出各种数据类型。
2. 实现一个功能更强大的计算器。
     */

class CalculatorPlus {

    //逆波兰表达式：
    public static void main(String[] args) {
        System.out.println("---计算器---");
        System.out.println("请输入 需要计算的式子:");
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        //使用栈，当遇到括号时
        String ex = toReversePolishNotation(expression);
        System.out.println(ex);
        System.out.println(calcReversePolishNotation(ex));
    }

    //计算逆波兰表达式：  解析式子错误...
    public static double calcReversePolishNotation(String s){
        double result = 0;
        //使用栈;
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c<='9'){
                stack.push(Double.parseDouble(c+""));
            }else{
                double a = stack.pop();
                double b= stack.pop();
                double d = 1.0;
                switch (c) {
                    case '+':
                        d= a+b;
                        break;
                    case '-':
                       d = a-b;
                        break;
                    case '*':
                        d = a*b;
                        break;
                    case '/':
                        d = a/b;
                        break;

                }

                stack.add(d);

            }
        }
        result = stack.pop();
        return result;
    }
    //将普通算式转为 逆波兰表达式
    //1 * (5 +10) + 1*15 --> 1 5 10 + * 1 15 * +
    //1. 当遇到 数值 直接输出
    //2. 操作符 保持单调递增(除括号，由下至上)
    //3. 优先级: + == - < * == /
    //4. 当遇到相同时 也必须弹出栈
    public static String toReversePolishNotation(String s) {
        /*
        单线程操作大量数据使用 StringBuilder。
        多线程操作大量数据使用 StringBuffer。
        * */
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //数值直接输出
            if (c >= '0' && c <= '9') {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                //弹出至 ( 处
                char t = stack.pop();
                while (t != '(') {
                    //输出字符
                    result.append(t);
                    t = stack.pop();
                }
            } else {
                if (!stack.empty()) {
                    //当为 + - * /
                    char t = stack.peek();
                    //当优先级为小时
                    while (!stack.empty() && !higherPriority(c,t) && t != '(') {
                        result.append(stack.pop());
                        if(!stack.empty()){
                            t = stack.peek();
                        }
                    }
                }
                stack.push(c);
            }
        }
        while (!stack.empty()){
            result.append(stack.pop());
        }


        return result.toString();
    }

    private static boolean higherPriority(char t, char c) {
        return getPriorityValue(t) > getPriorityValue(c);
    }

    private static int getPriorityValue(char c) {
        int v = -1;
        switch (c) {
            case '+':
            case '-':
                v = 0;
                break;
            case '*':
            case '/':
                v = 1;
                break;
            case '(':
                v = 2;
                break;
        }
        return v;
    }


}


