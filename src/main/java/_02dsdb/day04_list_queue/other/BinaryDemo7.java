package _02dsdb.day04_list_queue.other;

/**
 * @author kiro
 * @description:
 * @data 16:41 13/11/2023
 **/
/*
a % b = a & (b-1)
 */
public class BinaryDemo7 {
    public static void main(String[] args) {
        int a = 13;
        int b = 4;
        // b为2的次幂，截取后面的位数
        // 13        4
        //
        System.out.println("a & (b -1) = " + (a & (b -1)));

    }
}
