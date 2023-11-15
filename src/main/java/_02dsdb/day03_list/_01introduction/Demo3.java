package _02dsdb.day03_list._01introduction;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author kiro
 * @description:
 * @data 11:37 11/11/2023
 **/
public class Demo3 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        int c = 0;
        for (String string : list) { // 相当于while循环， hasNext()
            c++;
        }
        System.out.println(c);
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }

        while (iterator.hasPrevious()) {
            System.out.println("iterator.previous() = " + iterator.previous());
        }

        System.out.println("iterator.nextIndex() = " + iterator.nextIndex());
        System.out.println("iterator.hasPrevious() = " + iterator.previousIndex());

    }

    @Test
    public void test5() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        System.out.println("list = " + list);
        ListIterator<String> listIterator = list.listIterator();
        // void add(E e) : 添加一个数据到当前遍历位置,并且把指针往后挪一下
        listIterator.add("test");
        // void set(E e) : 修改刚刚遍历过的元素位置
        listIterator.next();
        listIterator.set("fff");        // java.lang.IllegalStateException
        System.out.println("list = " + list);
        listIterator.remove();
        // listIterator.remove();
    }

    @Test
    public void test6(){
        // listIterator(int index)  可传入 index代表目前状态
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        System.out.println("list = " + list);
        ListIterator<String> listIterator = list.listIterator(list.size());
        System.out.println("listIterator.previous() = " + listIterator.previous());

    }
}
