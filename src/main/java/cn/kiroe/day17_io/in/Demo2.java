package cn.kiroe.day17_io.in;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 11:30 1/11/2023
 **/
public class Demo2 {

    public static void main(String[] args) {
        try(FileInputStream in = new FileInputStream("a.txt")){
            byte[] bytes = new byte[4];
            int readCount = in.read(bytes);
            System.out.println("new String(bytes) = " + new String(bytes));
            System.out.println("readCount = " + readCount);
            int readCount1 = in.read(bytes);
            System.out.println("new String(bytes) = " + new String(bytes,0,readCount1));
            System.out.println("readCount1 = " + readCount1);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
