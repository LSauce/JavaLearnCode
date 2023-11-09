package cn.kiroe.day18_io2._02charstream._05buffer;

import java.io.*;

/**
 * @author kiro
 * @description:
 * @data 15:21 2/11/2023
 **/
public class Demo {

    public static void main(String[] args) {
        // 创建输出流对象
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("IOTest/a.txt"))) {
            // write

            writer.write("testte你啊哈哦打撒佛挡杀佛");
            writer.newLine();//换行
            // flush
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
