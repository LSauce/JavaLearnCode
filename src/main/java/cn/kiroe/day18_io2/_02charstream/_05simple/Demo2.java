package cn.kiroe.day18_io2._02charstream._05simple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 15:14 2/11/2023
 **/
public class Demo2 {
    // 不能指定字符集
    public static void main(String[] args){
        try(FileReader fileReader = new FileReader("a.txt")) {
            char[] chars = new char[1024];
            int readCount = fileReader.read();
            while ((readCount = fileReader.read(chars))!= -1){
                System.out.println(new String(chars,0,readCount));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
