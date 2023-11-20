package cn.kiroe.day13_object._04equals._02note;

/**
 * @author kiro
 * @description:
 * @data 16:27 27/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
        Double a = 1.0;
        Double b = 0.9;
        System.out.println(a-b == 0.1);
        System.out.println("Double.compare(a,b) = " + Double.compare(a-b, 0.1));
    }
}
