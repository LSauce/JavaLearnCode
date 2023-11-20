package cn.kiroe.day18_io2._01bytesstream.buffer;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 10:24 2/11/2023
 **/
public class Demo2 {

    public static void main(String[] args) throws IOException {
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("IOTest/a.txt"), 4);
        outputStream.write("abcdefgh".getBytes());
        // try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("IOTest/a.txt"), 1024)) {
        //     // 当 数据大于缓冲区，会自动刷新
        //     outputStream.write("abcdfghjkl".getBytes()); // 当大于 size时，会全部flush
        //
        // } catch (IOException e) {
        //     throw new RuntimeException(e);
        // }
    }
}
