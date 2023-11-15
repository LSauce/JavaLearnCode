package _02dsdb.day05_map.homework;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kiro
 * @description:
 * @data 19:55 14/11/2023
 **/
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int[] newNums =  new int[nums.length+1];
        // 不会自动 包装，所以不能直接填list
        System.arraycopy(nums,0,newNums,0,newNums.length-1);
        System.out.println("newNums = " + Arrays.toString(newNums));
      //  List<Integer> list = new ArrayList<>(Arrays.asList(nums));
        Set<Integer> integers = new HashSet<>();
        System.out.println("integers = " + integers);
    }

    @Test
    public void test(){
        // 创建一个数组
        int[] array = {1,2,3,4};
        List<int[]> list1 = Arrays.asList(array);// 他是将 数组转为int[] 类型。。。

        // 将数组转换为列表
        //List<Integer> list = new ArrayList<>(Arrays.asList(array));

        // 打印列表内容
        // for (Integer item : list1) {
        //     System.out.println(item);
        // }
    }
    @Test
    public void test2(){
        int[] array = {1, 2, 3, 4, 5};

        // 将int[]数组转换为List<Integer>
       //  List<Integer> list = Arrays.asList(array);

        // // 打印List元素
        // for (Integer num : list) {
        //     System.out.println(num);
        // }
    }

    @Test
    public void test3(){
        // 使用stream转
        int[] nums =  {1,2,3,4,5,6};
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    @Test
    public void test4(){
        // 测试 set设置初始 容量
        // 还是设定初始容量，一个一个添加最快，初始容量可
        HashSet<Integer> integers = new HashSet<>(2);
        integers.add(1);
        integers.add(1);

    }
}
