package cn.kiroe.day17_io._01bytestream.out;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 10:28 1/11/2023
 **/
public class Demo4 {

    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("b.txt", true);

        outputStream.write("aaabsdabfsdaf\r\n".getBytes());
        // 系统换行符
        // System.lineSeparator();
        outputStream.write(("abcd"+System.lineSeparator()).getBytes());
        outputStream.close();

    }
}
