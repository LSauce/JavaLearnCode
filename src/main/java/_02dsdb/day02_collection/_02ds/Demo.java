package _02dsdb.day02_collection._02ds;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        String[] strings = new String[]{"1", "2", "3", "4", "5", null, null, null};
        int count = 5;
        // 再 index=2中 ，插入 "-2“
        ArrayListD<String> stringArrayListD = new ArrayListD<>(String.class, 10);
        stringArrayListD.add("t");
        stringArrayListD.add("t1");
        stringArrayListD.add("t2");
        stringArrayListD.add("t3");
        stringArrayListD.add(1, "ffff");
        System.out.println("stringArrayListD = " + stringArrayListD);
        System.out.println("stringArrayListD.del(3) = " + stringArrayListD.del(3));
        System.out.println("stringArrayListD.del(3) = " + stringArrayListD.del(1));
        System.out.println("stringArrayListD = " + stringArrayListD);


    }
}


class ArrayListD<T> {

    private T[] arr;
    private int size = 0;

    public ArrayListD(Class<T> type, int length) {
        this.arr = (T[]) Array.newInstance(type, length);
    }

    // 增
    public boolean add(T t) {
        if (size > arr.length) {
            return false;
        }
        arr[size++] = t;
        return true;
    }

    public boolean add(int index, T t) {
        if (size > arr.length || size < index + 1) {
            return false;
        }

        for (int i = this.size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = t;
        size++;
        return true;
    }

    // 删
    public boolean del(int index) {
        // 左侧移动
        if (index + 1 > size) {
            return false;
        }

        for (int i = index; i < size; i++) {
            arr[i] = arr[i+1];
        }
        return true;
    }
    // 改
    public boolean update( int index,T t){
        if(index > size -1){
            return false;
        }
        arr[index] = t;
        return true;
    }
    // 查
    public T get(int index){
        if (index > size -1){
            return null;
        }
        return arr[index];
    }


    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayListD{" +
                "arr=" + Arrays.toString(arr) +
                ", length=" + size +
                '}';
    }
}
