package cn.kiroe.day18_io2._02charstream._03transform;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kiro
 * @description:
 * @data 14:56 2/11/2023
 **/
public class Demo2 {

    public static void main(String[] args) {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream("IOTest/a.txt"))) {

            int readCount;
            char[] chars = new char[1024];
            if((readCount = in.read(chars))!=-1){
                System.out.println(new String(chars,0,readCount));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
