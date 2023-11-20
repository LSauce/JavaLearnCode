package _02dsdb.day02_collection._02ds;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

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
        System.out.println("stringArrayListD.del(3) = " + stringArrayListD.remove(3));
        System.out.println("stringArrayListD.del(3) = " + stringArrayListD.remove(1));
        System.out.println("stringArrayListD = " + stringArrayListD);

        // 使用 自定义迭代器
        Iterator<String> iterator = stringArrayListD.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if("t3".equals(next)){
                iterator.remove();
            }
        }
        System.out.println("stringArrayListD = " + stringArrayListD);
        stringArrayListD.iterator().forEachRemaining((t)->{
            System.out.println(t);
        });
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
    public boolean remove(int index) {
        // 左侧移动
        if (index + 1 > size) {
            return false;
        }

        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return true;
    }

    // 改
    public boolean update(int index, T t) {
        if (index > size - 1) {
            return false;
        }
        arr[index] = t;
        return true;
    }

    // 查
    public T get(int index) {
        if (index > size - 1) {
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
    public Iterator iterator(){
        return new Ite<T>();
    }
    /**
     * 迭代器的 功能 ：
     * next()  向下位移一位，并返回当前值，当到终点是 返回 null
     * hasNext 判断是否到尾部，到了为尾部，即返回null
     * remove 调用list的方法 ，移出 该数据
     *forEachRemaining(action)）  对所以数据执行action操作，直到 末尾或异常
     */
    private class Ite<T> implements Iterator<T> {
        // 成员变量
        int cursor;
        int lastIndex = size;
        public Ite() {

        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if(hasNext()){
                return (T) get(cursor++);
            }
            return null;
        }

        @Override
        public void remove() {
           if(cursor-1 < size){
               ArrayListD.this.remove(cursor-1);
           }
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            while (hasNext()){
                action.accept(next());
            }
        }
    }
}
