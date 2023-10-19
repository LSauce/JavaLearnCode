package cn.kiroe.day04.homework;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class NumericalBasicExercise {
    /*
    数组基本使用练习
定义一个double数组用来存放学生成绩，然后键盘录入10位同学的成绩并存入数组，求这10位同学成绩的平均值。（提示：这里可以用循环来完成十次键盘录入）
定义一个String数组，输出该数组的长度，并用多种方式遍历打印数组元素（常见的方式遍历即可）
注：

请合理使用方法，不要胡子眉毛一把抓把代码全部写在main方法里。

数组遍历的方式，比如for、增强for或者使用工具类等等。

建议两个需求分开写两个类完成。
     */
    //定义一个double数组用来存放学生成绩，
    // 然后键盘录入10位同学的成绩并存入数组，
    // 求这10位同学成绩的平均值。（提示：这里可以用循环来完成十次键盘录入）
    @Test
    public void exercise1(){
        double[] scores = new double[10];
        System.out.println("---计算平均分---");
        System.out.println("请输入10为同学成绩");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            System.out.print("第"+(i+1)+"位：");
            scores[i] = in.nextDouble();

        }
        in.close();

        System.out.println("十位同学平均分为:"+ average(scores));
    }

    public double average(double[] arr){
        double sum = 0;
        for (double v : arr) {
            sum += v;
        }

        return sum/arr.length;
    }
    //定义一个String数组，输出该数组的长度，并用多种方式遍历打印数组元素（常见的方式遍历即可）
    @Test
    public void exercise2(){
        String[] arr = {"fasd","fas23d","fas423d","f5325asd","fas53252d"};
        print1(arr);
        print2(arr);
        print3(arr);
    }

    public void print1(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public void print2(String[] arr){
        for (String string : arr) {
            System.out.print(string + " ");
        }
        System.out.println();
    }

    public void print3(String[] arr){

        System.out.println(Arrays.toString(arr));
    }


}
