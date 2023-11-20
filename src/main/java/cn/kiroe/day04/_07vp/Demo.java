package cn.kiroe.day04._07vp;

/**
 * @author kiro
 * @description:
 * @data 11:16 17/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
        //不要写 两个 可变量参数 都匹配的方法，当调用时会报错


    }

    //
    public int getSum(int... numbers){
        int sum =0;
        if (numbers != null){
            for (int number : numbers) {
                sum += number;
            }
        }
        return sum;
    }
}
