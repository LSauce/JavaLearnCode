package cn.kiroe.day18_io2._03otherstream._01data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 15:59 2/11/2023
 **/
/*
需求：  向文件中写3.14、 1000
 */
public class Demo {

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("IOTest/a.txt")){
            out.write(65);
            out.write("3.14".getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
