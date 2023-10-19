package cn.kiroe.day04._06operations._04copy;

import java.util.Arrays;

public class Demo {


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 34, 4, 5, 6, 6};
        System.out.println(array);
        int[] array2 = copyArray(array);
        System.out.println(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println("-----");

        int[] copy = addElementArray(array, 999, 2);
        System.out.println("Arrays.toString(array) = " + Arrays.toString(copy));

        // 通过系统方法copy
        int[] copy2 = new int[array2.length];
        System.arraycopy(array2, 0, copy2, 0, array2.length);
        System.out.println(Arrays.toString(copy));
    }

    public static int[] copyArray(int[] array) {
        int[] arrayCopy = new int[array.length];
        for (int i = 0; i < arrayCopy.length; i++) {
            arrayCopy[i] = array[i];
        }

        return arrayCopy;
    }

    public static int[] addElementArray(int[] array, int value, int index) {
        int[] arrayCopy = null;
        if (array != null && index < array.length) {
            int j = 0;
            arrayCopy = new int[array.length + 1];
            // (i++,j++) 只有for中能写
            for (int i = 0; i < arrayCopy.length; i++, j++) {
                if (index == i) {
                    arrayCopy[i] = value;
                    j--;
                } else {
                    arrayCopy[i] = array[j];
                }
            }
        }
        return arrayCopy;
    }

    public static int[] delElementArray(int[] array,int value){

        return new int[0];
    }
}
