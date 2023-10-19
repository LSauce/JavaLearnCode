package cn.kiroe.day04.homework;

import org.junit.Test;

import java.util.Arrays;

public class CourseCode {
    public static void main(String[] args) {

    }
/*

练习1：

> 静态初始化一个数组，输出数组名及元素。然后给数组中的元素赋值，再次输出数组名及元素。
 */
    @Test
    public  void exercise1() {
        //静态初始化一个数组，
        Integer[] arr = {1, 2, 4, 5};
        // 输出数组名及元素。
        System.out.print(arr+": ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
        // 然后给数组中的元素赋值，
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*i;
        }
        // 再次输出数组名及元素。
        printArray(arr);
    }

    public static <T> boolean printArray(T[] arr){
        if(arr==null){
            return false;
        }
        System.out.println(arr + ": "+ Arrays.toString(arr));

        return true;
    }
    /*
练习2：

> 分别静态、动态初始化两个数组，分别输出数组名及元素。然后分别给数组中的元素赋值，再次分别输出数组名及元素。
*/
    @Test
    public void exercise2(){
        //分别静态、动态初始化两个数组，
        Integer[] arr1 = {1,2,34,4};
        Integer[] arr2 = new Integer[10];
        // 分别输出数组名及元素。
        printArray(arr1);
        printArray(arr2);
        // 然后分别给数组中的元素赋值，
        for (int i = arr1.length - 1; i >= 0; i--) {
            arr1[i] = i+2;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i*i;
        }
        // 再次分别输出数组名及元素。
        printArray(arr1);
        printArray(arr2);
    }

    /*
练习3：

> 定义两个数组：
>
> - 静态初始化一个数组，输出数组名，元素取值，长度
> - 然后声明第二个数组，把第一个数组的地址赋值给第二个数组。
> - 输出第二个数组的数组名，元素取值，长度
> - 然后给第二个数组赋值，再次输出两个数组的名及元素
 */
    @Test
    public void exercise3(){
        //> - 静态初始化一个数组，输出数组名，元素取值，长度
        Integer[] arr=  {1,2,3};
        printArray(arr);
        System.out.println("长度："+ arr.length);
        // > - 然后声明第二个数组，把第一个数组的地址赋值给第二个数组。
        Integer[] arr2= arr;
        // > - 输出第二个数组的数组名，元素取值，长度
        printArray(arr2);
        System.out.println("长度："+ arr.length);
        //> - 然后给第二个数组赋值，
        for (int i = arr2.length - 1; i >= 0; i--) {
            arr2[i] *= 100;
        }
        // 再次输出两个数组的名及元素
        printArray(arr);
        printArray(arr2);

    }
    @Test
    public void reverseArrayTest(){
        String[] arr = {"abc","abcq","afffbc","abce","abct"};
        System.out.println("Arrays.toString(reverseArray(arr)) = " + Arrays.toString(reverseArray(arr)));
    }
    //数组的逆序
    public <T> T[] reverseArray(T[] arr){
        if (arr != null){
            for (int i = 0; i < arr.length/2; i++) {
                T t=  arr[i];
                arr[i] = arr[arr.length-1-i];
                arr[arr.length-1-i] = t;
            }
        }
        return arr;
    }
    @Test
    public void copyArrayTest(){
        String[] arr = {"abc","abcq","afffbc","abce","abct"};
        printArray(arr);
        printArray(copyArray(arr));
    }
    //数组的拷贝
    public String[] copyArray(String[] arr){
        String[] arrCopy =new String[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            arrCopy[i] =  arr[i];
        }

        return arrCopy;
    }



}
