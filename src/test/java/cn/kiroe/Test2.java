package cn.kiroe;

public class Test2 {

    public static void main(String[] args) {
        System.out.println(getMax(1,2,3,4,5,6));//语法糖
        int[] arr = new int[]{1,2,3};
        System.out.println(getMax(arr));//也可用 数值
        //System.out.println(test(1,1,1,1)); //为什么不限定 一个方法名只能有一个 可变长度
    }
    //int ... a 为可变长参数，可传数值
    public static int getMax(int ... a){
        int max =0;

        for (int i = 0; i < a.length; i++) {
            if(max < a[i]){
                max = a[i];
            }
        }
        return max;
    }
    // 只能放最后
    /*public static void test2(int... var, int b ){

    }*/
    public static void test(int... var) {
    }
    //两个方法都将无法使用
    public static void test(int a, int... var) {
    }


}
