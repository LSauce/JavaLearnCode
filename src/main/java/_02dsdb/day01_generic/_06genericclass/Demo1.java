package _02dsdb.day01_generic._06genericclass;

/**
 * @author kiro
 * @description:
 * @data 15:50 9/11/2023
 **/

import org.junit.Test;

/**
 * 泛型类，主要把泛型 定义在类上面
 * <pre>// 防止格式化 问题
 *     class 类名<T,D> {
 *
 *
 * </pre>
 *
 * }
 */

public class Demo1 {
    @Test
    public void test1(){
        // 泛型的写法
        User<String> user1 = new User<String>();
        // 这里写String，为了确定类 不确定类型的类型

        String data = user1.getData();
        User<Integer> integerUser = new User<Integer>();
        Integer data1 = integerUser.data;

    }

    @Test
    public void test2(){
        // 泛型的第二种写法
        User<String> user1 = new User<>();
        String data = user1.data;

        // 推荐第二种写法， 前面写泛型，后面不写
    }

    @Test
    public void test3(){
        // 如果user定义了泛型 ，但是不写尖括号，
        User user = new User();
        // 如果定一了 泛型，而不指定泛型，则类型为 Object
        Object data = user.getData();

    }

}


class User<T>{
    T data;

    public T getData() {
        return data;
    }
}
