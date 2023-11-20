package cn.kiroe.day18_io2._02charstream._04.copy;

import cn.kiroe.day18_io2.utils.FileUtils;

import java.io.*;

/**
 * @author kiro
 * @description:
 * @data 15:04 2/11/2023
 **/
public class Demo {
    public static void main(String[] args) {

        try (InputStreamReader in = new InputStreamReader(new FileInputStream("IOTest/a.txt")); OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("IOTest/a_copy.txt"))) {
            FileUtils.copy3(in,out);


        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
