package _02dsdb.day07_stream.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kiro
 * @description:
 * @data 19:31 16/11/2023
 **/
/*
1, 给定一个数字列表, 如何返回一个由每个数的平方构成的列表?
// [1,2,3,4,5] -> [1,4,9,16,25]
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
 */
public class Work1 {
    public static void main(String[] args) {
        List<Integer> squareList = getSquareList(Arrays.asList(1,2,3,4,5));
        System.out.println("squareList = " + squareList);
    }
    // 1, 给定一个数字列表, 如何返回一个由每个数的平方构成的列表?
    // // [1,2,3,4,5] -> [1,4,9,16,25]
    // List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    public static List<Integer> getSquareList(List<Integer> source){
        if(source == null){
            return  null;
        }
        List<Integer> list = source.stream().map(i -> i * i).collect(Collectors.toList());
        return list;
    }
}
