package _02dsdb.day01_generic._06genericclass.demo5;

import org.junit.Test;

import javax.xml.crypto.Data;

/**
 * @author kiro
 * @description:
 * @data 16:31 9/11/2023
 **/

public class Demo5 {
    public static void main(String[] args) {
        Father<Integer> f = new Father<>();
        Integer ft = f.ft;

        // Son1 定义时没有指定Father泛型的类型，所以默认为Object
        Son1 son1 = new Son1();
        Object ft1 = son1.ft;

        // Son2 定义时，未指定泛型，指定了 Father泛型为String，所以ft为String
        Son2 son2 = new Son2();
        String ft2 = son2.ft;

        //Son3 定义时，指定泛型E，指定了 Father泛型为Integer，所以ft为Integer
        Son3<String> son3 = new Son3<>();
        Integer ft3 = son3.ft;

        // Son4 定义时，指定泛型E，指定了 Father泛型为E，所以ft类型和子类一致
        Son4<Integer> son4 = new Son4<>();
        Integer ft4 = son4.ft;
        Son4<String> son41 = new Son4<>();
        String ft41 = son41.ft;

        // Son5 指定T。 与符号无关
        Son5<String> son5 = new Son5<>();
        String ft5 = son5.ft;

    }

    public static int[] getArray(){
        return new int[]{1, 2, 4, 5};
    }

    @Test
    public void test2(){
        // 创建Son1，能不能拿到 ft这个变量
        // 是什么类型
        // 继承的时候没有指定 父类的泛型，
        // 父类的泛型为默认的类型，Object
        Son1 son1 = new Son1();
        Object ft = son1.ft;
    }

    @Test
    public void test3(){
        Son2 son2 = new Son2();
        // 在继承是，指定了 泛型的类型是String,所以泛型就是String
        String ft = son2.ft;

    }

    @Test
    public void test4(){
        Son3<String> stringSon3  =new Son3<>();
        Integer ft = stringSon3.ft;

        Son4<Double> son4 = new Son4<>();
        Double ft1 = son4.ft;
    }

    @Test
    public void test5(){
        Son6<Float> floatSon6 = new Son6<>();
        Float ft = floatSon6.ft;
    }
}

class Father <T> {
    T ft;
}
class Son1 extends Father{ }
class Son2 extends Father<String>{}
// 这个前面的E叫做定义了一个泛型E
class Son3<E> extends Father<Integer>{}

// 这里只是看起来好像是Integer。其实是定义了一个泛型叫做Integer。它和 java.lang.Integer有区别。
// class Son3<Integer> extends Father<Integer>{}
class Son4<E> extends Father<E>{}
class Son5<T> extends Father<T>{}
class Son6<Integer> extends Father<Integer>{}