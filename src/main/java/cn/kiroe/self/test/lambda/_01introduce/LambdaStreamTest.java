package cn.kiroe.self.test.lambda._01introduce;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author kiro
 * @description:
 * @data 22:18 24/10/2023
 **/
public class LambdaStreamTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        // list.stream() //新建流对象
        //.map((Function<Integer, Object) integer -> integer) //传入 映射处理
        // forEach(System.out::println) //传入 遍历后操作
        list.stream().map((Function<Integer, Object>) integer -> integer*integer).
                forEach((a)->{
                    if(a instanceof Integer){
                        a = (Integer)a +1;
                    }

                    System.out.println(a);
                });

        list.stream().forEach(System.out::println);



    }
}
