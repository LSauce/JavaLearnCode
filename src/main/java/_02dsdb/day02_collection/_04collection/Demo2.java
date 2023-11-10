package _02dsdb.day02_collection._04collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Demo2 {
    /*

    //    ---------------------------------特殊方法---------------------------------
//    void clear()： 清空collection
//    boolean equals(Object o) ： 判断是否相等
//    int hashCode()： 计算hashCode
//    boolean isEmpty(): 是否为空
//    int size()： collection里面的元素个数
     */

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 45, 5, 6, 7));
        System.out.println("integers = " + integers);
        //    void clear()： 清空collection
        // integers.clear();
        System.out.println("integers = " + integers);
//    boolean isEmpty(): 是否为空
        System.out.println("in:qtegers.isEmpty() = " + integers.isEmpty());
        // stack有empty() ，但都有 isEmpty()
//    int size()： collection里面的元素个数
        System.out.println("integers.size() = " + integers.size());
//    boolean equals(Object o) ： 判断是否相等
        ArrayList<Integer> integers2 = new ArrayList<>();
        System.out.println("integers.equals(integers) = " + integers.equals(integers2));
//    int hashCode()： 计算hashCode
        System.out.println("integers2.hashCode() = " + integers2.hashCode());

        /*

        public int hashCode() {
        int var1 = 1;

        Object var3;
        for(Iterator var2 = this.iterator(); var2.hasNext(); var1 = 31 * var1 + (var3 == null ? 0 : var3.hashCode())) {
            var3 = var2.next();
        }

        return var1;
    }
         */
        // 对应API 要的记名字最好
        ArrayList<Object> objects = new ArrayList<>();

    }


}
