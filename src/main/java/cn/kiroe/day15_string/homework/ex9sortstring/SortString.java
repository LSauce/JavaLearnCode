package cn.kiroe.day15_string.homework.ex9sortstring;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kiro
 * @description:
 * @data 20:22 30/10/2023
 **/
/*

(选做)创建一个长度是8的的字符串数组


对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)

注1： 不能使用Arrays.sort() 要自己写 可以使用冒泡排序

注2： 无视大小写，即 Axxxx 和 axxxxx 没有先后顺序

举例: 排序前 [UxoEl, If3js, 9SSwC, czHuA, lZLBF, IhynX, VgjrY, dJAIW]

排序后 [9SSwC, czHuA, dJAIW, If3js, IhynX, lZLBF, UxoEl, VgjrY]


 */
public class SortString {
    public static void main(String[] args) {
        String[] array = {"UxoEl", "If3js", "9SSwC", "czHuA", "lZLBF", "IhynX",
                "VgjrY", "dJAIW"};
        ArraysUtil.sort(array,(o1,o2)-> (o1.charAt(0)+"").compareToIgnoreCase(o2.charAt(0)+""));

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

    }
}


class ArraysUtil {
    /**
     * 快排
     *
     * @param array
     * @param comparator
     * @param <T>
     */
    public static <T> boolean sort(T[] array, Comparator<T> comparator) {
        if (array == null || comparator == null) {
            return false;
        }
        quickSort(array, 0, array.length-1, comparator);
        return true;
    }

    private static <T> void quickSort(T[] array, int start, int end, Comparator<T> comparator) {

        //实现细节：
        // 9. 递归结束条件为 当只有一个值时
        if (start >= end) {
            return;
        }
        // 1. 随机选定一个数，将其与第一位交换
        int random = getRandom(start, end);
        swap(array, start, random);
        // 2. 使用双指针l,r, 分别位于两头
        int l = start;
        int r = end;
        // 3. 将选定的值记录后，数组便多了个 可使用的空位,位于l处
        T p = array[l];
        while (l < r) {
            // 4. 所以从 右侧开始 查询小于标定的值，
            while (l < r && comparator.compare(array[r], p) >= 0) {
                r--;
            }
            // 5. 右侧查询到后，放置于l空位处，r处位置便空出
            array[l] = array[r];
            // 6. 同理，l从左侧查询，查询大于标定后，放置与r位置处
            while (l < r && comparator.compare(array[l], p) <= 0) {
                l++;
            }
            array[r] = array[l];

        }

        // 7， 循环操作结束后，当l==r时，将 标定放入
        array[l] = p;

        // 8. 最后，进行 递归调用，传入左侧和右侧，去除中间
        quickSort(array, start, l - 1, comparator);
        quickSort(array, l + 1, end, comparator);

    }

    private static int getRandom(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
