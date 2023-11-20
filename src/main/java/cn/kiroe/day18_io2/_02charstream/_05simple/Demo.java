package cn.kiroe.day18_io2._02charstream._05simple;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 15:10 2/11/2023
 **/
public class Demo {

    public static void main(String[] args) {
        // 创建输出流对象
        try(FileWriter fileWriter = new FileWriter("a.txt");){
            // wirte
            fileWriter.write("发撒多发点发的发的发的说法噶大萨达");
            // flush
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // write
        // flush
        // close

    }
}
