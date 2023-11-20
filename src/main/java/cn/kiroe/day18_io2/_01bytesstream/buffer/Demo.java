package cn.kiroe.day18_io2._01bytesstream.buffer;

import java.io.*;

/**
 * @author kiro
 * @description:
 * @data 10:12 2/11/2023
 **/
public class Demo {

    public static void main(String[] args) {
        File file = new File("IOTest");
        file.mkdirs();
        // 创建输出流对象
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("IOTest/h.txt"))) {

            // write(int b)
            outputStream.write(97);
            // write(byte[] bytes)
            outputStream.write("abcd".getBytes());
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
