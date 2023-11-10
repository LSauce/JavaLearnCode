package _02dsdb.day02_collection._02ds;

import java.util.ArrayList;
import java.util.LinkedList;

public class Demo2 {

    public static void main(String[] args) {
        LinkedListD<Integer> integers = new LinkedListD<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        System.out.println("add integers = " + integers);
        integers.remove(1);
        System.out.println("remove integers = " + integers);
        integers.set(0,3333);
        System.out.println("set integers = " + integers);
        System.out.println("integers.get(3) = " + integers.get(3));
        System.out.println("integers.indexOf(3333) = " + integers.indexOf(999));
    }
}
