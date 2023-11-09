package examination;

import com.google.protobuf.CodedOutputStream;

import java.io.*;

/**
 * @author kiro
 * @description:
 * @data 19:28 8/11/2023
 **/
public class Demo {
    static boolean aBoolean;
    public static void main(String[] args) throws IOException {
        byte a= 127;
        String t= String.valueOf(100);
        StringBuilder sb = new StringBuilder(100);
        System.out.println("t.equals(sb) = " + t.equals(sb));
        System.out.println("aBoolean = " + aBoolean);
        Integer i = 5;
        // new Object().getClass().getDeclaredMethod("")

        // Serializable
        new FileWriter("IOTest/c2.txt");
        new ArrayIndexOutOfBoundsException();

    }
    public class Test3{

    }
    private String stuId;


}

abstract class Test{
    public Test() {
    }
    abstract void test();
}

