package _02dsdb.day02_collection.homework;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 22:34 10/11/2023
 **/
public class GenericTypeEraseTest<T> {
    public static void main(String[] args) {
        // 验证 数组类型转换 问题
        // 1. String[] 隐式--> Object[] 强制--> String[]
        // 不报错，因为数组类型匹配
        Object[] array1 = new String[]{"1", "2", "3", "4", "5"};
        String[] SArray1 = (String[]) array1; // 运行时不报错，
        System.out.println("SArray1 = " + Arrays.toString(SArray1));

        // 2. Object[] 强制--> String[]  运行时报错
        Object[] array2 = new Object[]{"1", "2", "3", "4", "5"};
        // java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
        String[] SArray2 = (String[]) array2; // 运行时 报错 ， 不能从 Object[] 强制--> String[]
        System.out.println("SArray1 = " + Arrays.toString(SArray2));

        // 3. 使用List.toArray()方法
        // 由于 有泛型擦除 所以返回实际为 Object[]
        // 所以 Object[] -> String[] 报错
        ArrayList<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Object[] array3 = list.toArray();
        String[] SArray3 = (String[]) array3; //运行报错，错误和2相同
        System.out.println("SArray3 = " + SArray3);

        // 4. 使用List.toArray(T[] a)
        //  该方法中 通过 Array.newInstance(Class<?> componentType, int length)
        // 创建对象，Class<?>为字节码对象，所以能通过反射 创建类型对象 返回 String[]对象
        Object array4 = list.toArray(new String[0]);
        // 不报错, 因为为 String[] --> Object[] --> String[]
        String[] Sarray4 = (String[]) array4;
        System.out.println("Sarray4 = " + Arrays.toString(Sarray4));


        // 5. 如何创建泛型对象 即： new T[]
        // 通过Array.newInstance反射获取对象
        // array = (T[]) Array.newInstance(type, size);
        GenericTypeEraseTest<String> gtet = new GenericTypeEraseTest<>(String.class, 10);
        System.out.println("gtet.array = " + Arrays.toString(gtet.array));
    }
    T[] array;
    public GenericTypeEraseTest(Class<T> type, int size) {
        // 初始化对象
        //new T[10];   //编译报错 Type parameter 'T' cannot be instantiated directly
        // 为减少 强制类型转换异常 这个异常，如果能建Object[] 数组，违背了泛型设计的初衷
        array = (T[]) Array.newInstance(type, size);
    }

}
