package _02dsdb.day02_collection.homework;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 22:25 10/11/2023
 **/
public class Test1 {
    public static void main(String[] args) {

        Object[] arrayString = new Object[]{"123","123","rewrw"};
        String[] arrayString1 = (String[]) arrayString;
        String[] arrayString2 = (String[]) Arrays.copyOf(arrayString,arrayString.length);
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("1", "2", "2", "2", "2"));
        Object[] array = strings.toArray();
        // String [] ss2 = (String[])array;
        String s1 = (String) array[0];
        System.out.println("ss2 = " + s1);
        System.out.println("Arrays.toString(ss) = " + Arrays.toString(arrayString1));
        System.out.println("" + arrayString2);
    }
}
