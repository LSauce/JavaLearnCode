package cn.kiroe.day17_io.in;

import cn.kiroe.day15_string.homework.ex7comparable.Cat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 11:40 1/11/2023
 **/

/*
循环读取

 */
public class Demo3 {

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("a.txt")) {

            // read
            // 方式一 不推荐使用
            // readWhile1(in);
            // 方式二：
            // 1. 单字节读取
            // 表示读取到的字节值
            // readWhile2(in);
            // 2. byte[] 读取
            byte[] bytes = new byte[1024];
            int readCount;
            while ((readCount = in.read(bytes)) != -1) {
                System.out.println(new String(bytes,0,readCount));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readWhile2(FileInputStream in) throws IOException {
        int readData;
        while ((readData = in.read()) != -1) {
            System.out.print((char) readData);
        }
    }

    private static void readWhile1(FileInputStream in) throws IOException {
        while (true) {
            int read = in.read();
            if (read == -1) {
                break;
            }
            System.out.print((char) read);
        }
    }
}
