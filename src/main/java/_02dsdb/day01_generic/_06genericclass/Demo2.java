package _02dsdb.day01_generic._06genericclass;

import org.junit.Test;

/**
 * @author kiro
 * @description:
 * @data 16:01 9/11/2023
 **/
public class Demo2 {

    @Test
    public void test1(){
        User2<String,Integer> user2 = new User2<>();
        // 多个泛型按位置传递
        String data1 = user2.data1;
        Integer data2 = user2.data2;
        // class User3<K,V>
        // User3<String,Integer>, 则 K为String类型,
    }

    @Test
    public void test2(){
        // 多个泛型定义的情况下，必须全部指定，或者不写
        // 不能只用一个
        // 需要全部指定，获取全部不指定
        User3<String, Object,Object> user = new User3<>();
        // 全部不指定
        User3 user3 = new User3();

    }
}
// 泛型可以 定义多个
// 但一般建议两个
// 太多了有时难以分辨
class User2<K,V>{
    K data1;
    V data2;
}

// 泛型允许定义了 不使用
class User3<K,T,E>{
    K  data;

    public K getData() {
        return data;
    }
}
