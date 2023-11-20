package cn.kiroe.day15_string.homework.ex7comparable;

import sun.management.Agent;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 20:00 30/10/2023
 **/

/*

编写一个Cat类

成员变量：

int age，

String name，

double price

按以下要求进行自然排序：

直接实现Comparable接口，按照年龄的从小到大对Cat对象数组进行排序。

基于Comparator自定义比较器接口，用Lambda表达式对Cat对象数组进行排序。

按照price从高到低进行排序
按照name的长短从短到长进行排序
综合age，name，price进行排序，要求用Lambda表达式的方法引用语法。排序的规则是先按照age从小到大排序，age相同比较name长短，按照name的长度从短到长排序，name长度也相等，比较price，price按照从高到低排序。
如果你懒于自己搞容器数据，可以使用以下数据：

// Cat类有三参构造器(age, name, price)
Cat c = new Cat(1, "小黄", 100);
Cat c1 = new Cat(2, "小黑", 200);
Cat c2 = new Cat(2, "貉", 2000);
Cat c3 = new Cat(2, "马云的猫", 10000);
Cat c4 = new Cat(2, "云哥", 8000);
Cat c5 = new Cat(3, "吉祥物", 800);
Cat c6 = new Cat(2, "阿修罗", 9000);
Cat c7 = new Cat(2, "云堇", 300);
Cat c8 = new Cat(2, "咪咪", 400);
Cat c9 = new Cat(8, "养乐多", 500);
Cat[] cats = {c, c1, c2, c3, c4, c5, c6, c7, c8, c9};
 */
public class Test {



    public static void main(String[] args) {
        Cat c = new Cat(1, "小黄", 100);
        Cat c1 = new Cat(2, "小黑", 200);
        Cat c2 = new Cat(2, "貉", 2000);
        Cat c3 = new Cat(2, "马云的猫", 10000);
        Cat c4 = new Cat(2, "云哥", 8000);
        Cat c5 = new Cat(3, "吉祥物", 800);
        Cat c6 = new Cat(2, "阿修罗", 9000);
        Cat c7 = new Cat(2, "云堇", 300);
        Cat c8 = new Cat(2, "咪咪", 400);
        Cat c9 = new Cat(8, "养乐多", 500);
        Cat[] cats = {c, c1, c2, c3, c4, c5, c6, c7, c8, c9};
        Arrays.sort(cats);
        System.out.println("Arrays.toString(cats) = " + Arrays.toString(cats));

        /*

        基于Comparator自定义比较器接口，用Lambda表达式对Cat对象数组进行排序。

        按照price从高到低进行排序
        按照name的长短从短到长进行排序
        综合age，name，price进行排序，
        要求用Lambda表达式的方法引用语法。
        排序的规则是先按照age从小到大排序，
        age相同比较name长短，
        按照name的长度从短到长排序，
        name长度也相等，
        比较price，price按照从高到低排序。
         */
        Arrays.sort(cats,(o1,o2)->{
            if(o1.age != o2.age){
                return o1.age - o2.age;
            }
            if(o1.name.length() != o2.name.length()){
                return o1.name.length() - o2.name.length();
            }
            return (int) (o2.price - o1.price);
        });

        System.out.println("Arrays.toString(cats) = " + Arrays.toString(cats));
    }




}

