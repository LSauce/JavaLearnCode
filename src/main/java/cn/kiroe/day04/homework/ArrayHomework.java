package cn.kiroe.day04.homework;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class ArrayHomework {

    /*

 数组基本使用练习
 现在你去参加歌唱比赛。有10个评委打分，规则是去掉最高分和最低分，
 求平均分是最终成绩。请编码计算出你的最终成绩~

注：

请合理使用方法，不要胡子眉毛一把抓把代码全部写在main方法里。

最高分和最低分可能有多个，但只需要去掉其中一个即可（也就是说平均成绩要除以8）

建议给出下面的三个方法：

求数组中元素最大值的方法

求数组中元素最小值的方法

求数组中元素平均分的方法

------------------------------------------------------------------------------------------------------
  */
    @Test
    public void calcScoreTest(){
        calcScore();
    }
    public void calcScore() {
        System.out.println("---唱歌评分计算---");
        //评委分数为:
        Scanner in = new Scanner(System.in);
        double[] scores = new double[10];

        for (int i = 0; i < scores.length; i++) {
            System.out.print("请输入评委" + (i + 1) + "的评分：");
            scores[i] = in.nextInt();
        }


        System.out.println("平均分为：" + getAverage(scores));
        in.close();


    }

    public static double getAverage(double[] arr) {

        double average = -1;
        if (arr != null && arr.length >= 3) {
            double sum = 0;
            for (double v : arr) {
                sum += v;
            }
            sum -= getMin(arr) + getMax(arr);
            average = sum / (arr.length-2);
        }
        return average;
    }

    public static double getMax(double[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        double max = arr[0];

        for (double v : arr) {
            max = Math.max(v, max);
        }
        return max;
    }

    public static double getMin(double[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        double min = arr[0];
        for (double v : arr) {
            min = Math.min(v, min);
        }
        return min;
    }






    /*

数组基础练习——除以首元素
定义一个double类型的数组，让数组中每个元素（包括首位元素）都除以首位元素，得到的结果过作为该位置上的新元素。

例如数组[ 2.0 , 4.0 , 6.0 , 4.0 ] 经过方法运算得到新数组 [ 1.0 ,2.0 , 3.0 ,2.0 ]

注：

思考能不能直接在原先数组上完成，思考方法的返回值类型写什么。

注意元素取值的变化。
 */
    public static void doubleArrayTest() {
        double[] arr = new double[]{5, 2, 3, 4, 5, 6, 7};

        System.out.println("Arrays.toString(dealDoubleArray(arr)) = " + Arrays.toString(dealDoubleArray(arr)));

    }

    public static double[] dealDoubleArray(double[] arr) {

        //    数组基础练习——除以首元素
        //    定义一个double类型的数组，
        //    让数组中每个元素（包括首位元素）都除以首位元素
        //    ，得到的结果过作为该位置上的新元素。
        if (arr != null) {
            double head = arr[0];
            for (int i = 0; i < arr.length; i++) {
                arr[i] /= head;
            }
        }

        return arr;
    }

}
