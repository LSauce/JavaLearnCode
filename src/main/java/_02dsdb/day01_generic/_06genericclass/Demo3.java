package _02dsdb.day01_generic._06genericclass;

import org.junit.Test;

/**
 * @author kiro
 * @description:
 * @data 16:13 9/11/2023
 **/
/*

标识符尽量写 单个大写 字母
不要给自己挖坑

 */

public class Demo3 {

    @Test
    public void test(){
        User5<Integer> user5 = new User5<>();
        Integer data1 = user5.data1;
    }

    @Test
    public void test2(){
        // 泛型定义的类型 只能是引用类型，不能是基础类型
        // 如果要用，使用包装类型代替
        // User5<int> user5 = new User5<int>();
        User5<Integer> user5 = new User5<>();
        User5<Double> user51 = new User5<>();

    }

}
// 不建议写 类名，只用单个 大写字母
// class User5<String>{
//     String data1;
// }

class User5<T>{
    T data1;
    T data2;
}
