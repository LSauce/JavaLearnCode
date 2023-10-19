package cn.kiroe.day06.oop1.homework;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 20:10 17/10/2023
 **/
public class ArrayExercise3 {
    /*

    扩展（学有余力可完成，不强制）：

根据提供的代码，完成人名数组的删除、修改和查找方法。

其中：

删除人名，给出一个要删除的目标元素，用null替换它，表示删除

修改人名，需要明确指出修改哪个人名，以及修改成什么。

查找人名，找到后返回目标人名在数组中的位置（下标）

提供的代码在百度云盘 当天的作业目录下 找到对应文件:StringArrCRUDDemo.java

或者查找微信群聊天记录找到该文件。



可以直接在我的代码中，直接写完方法，直接测试。

也可以自己新写一个类，重新定义数组，定义方法，然后测试
     */
    public static void main(String[] args) {
        ArrayListD<String> list = new ArrayListD<>();
        //增
        list.add("test");
        list.add("test1");
        list.add("test2");
        list.add("test3");
        //删
        list.remove("test2");
        //改
        list.changeValue("test3","change");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) +" ");
        }

        //查
        System.out.println("\ntest1在：" +  list.indexOf("test1"));


    }
}

/**
 * 简陋ArrayList
 * 通过new数值来新增长度
 */
class ArrayListD<E> {

    private Object[] arr;

    public ArrayListD(int size) {
        this.arr = new Object[size];
    }

    public ArrayListD(E[] arr) {
        this.arr = arr;

    }

    public ArrayListD() {
        this(0);
    }

    // 增
    public boolean add(E e) {
        Object[] arrT = new Object[arr.length + 1];

        for (int i = 0; i < this.arr.length; i++) {
            arrT[i] = this.arr[i];
        }
        arrT[arrT.length-1] = e;
        this.arr = arrT;
        return true;
    }

    // 删
    public boolean remove(E e) {
        int index = indexOf(e);
        if(index >= 0){
            this.arr[index] = null;
            return true;
        }
        return false;
    }

    // 改 ,修改第一个查到的
    public int changeValue(E e, E value) {
        int index = indexOf(e);
        if (index >= 0) {
            arr[index] = value;
            return index;
        }
        return -1;
    }

    // 查
    public int indexOf(E e) {
        int index = -1;
        if (arr != null && e != null) {
            for (int i = 0; i < this.arr.length; i++) {
                if (e.equals(arr[i])) {
                    return i;
                }
            }
        }

        return index;
    }

    public E get(int index) {
        if (index >= 0 && index < arr.length) {
            return (E) this.arr[index];
        }
        return null;
    }

    public int size() {
        return arr.length;
    }
}


