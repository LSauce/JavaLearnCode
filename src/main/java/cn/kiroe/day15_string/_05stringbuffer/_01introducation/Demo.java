package cn.kiroe.day15_string._05stringbuffer._01introducation;

/**
 * @author kiro
 * @description:
 * @data 16:47 30/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //String string = new String();
        int sum =0;
        for (int i = 0; i < 1000000; i++) {
           // string += "a";
            sum += 1;
        }
        System.out.println("System.currentTimeMillis() - start = " + (System.currentTimeMillis() - start));

        long start1 = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append("a");
        }
        System.out.println("System.currentTimeMillis() - start = " + (System.currentTimeMillis() - start1));


    }
}
