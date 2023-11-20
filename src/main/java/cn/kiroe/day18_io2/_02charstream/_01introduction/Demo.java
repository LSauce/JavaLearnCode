package cn.kiroe.day18_io2._02charstream._01introduction;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 11:13 2/11/2023
 **/

/*

字节流读取英文
    没问题
    读取英文
    可能有问题
 */
public class Demo {

    public static void main(String[] args) {
        // 有JVM控制，获取系统编码
        String s = "你好";
        byte[] sc = s.getBytes();

        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("IOTest/a.txt"))) {
            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount = in.read(bytes)) != -1){
                System.out.println(new String(bytes,0,readCount));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
