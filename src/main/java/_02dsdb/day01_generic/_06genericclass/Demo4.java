package _02dsdb.day01_generic._06genericclass;

import org.junit.Test;

/**
 * 泛型的作用范围
 * 1.类上
 * 2.类中
 *
 * @author kiro
 * @description:
 * @data 16:25 9/11/2023
 **/
public class Demo4 {

    @Test
    public void test(){
        Son<Integer> integerSon =new Son<>();
        Integer data1 = integerSon.data1;
        Integer ft = integerSon.ft;

        Son<String> stringSon = new Son<>();
        String ft1 = stringSon.ft;
    }
}

class Father<T>{
    T ft;
}

class Son<T> extends Father<T>{
    T data1;
}


