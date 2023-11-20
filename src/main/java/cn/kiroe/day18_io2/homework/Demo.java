package cn.kiroe.day18_io2.homework;

import java.io.*;

/**
 * @author kiro
 * @description:
 * @data 23:26 2/11/2023
 **/
public class Demo {
    public static void main(String[] args) {

        File file = new File("");

        try( FileOutputStream fileOutputStream = new FileOutputStream(file);
             FileInputStream fileInputStream = new FileInputStream(file);) {

            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
