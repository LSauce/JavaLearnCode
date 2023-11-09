package cn.kiroe.day18_io2._01bytesstream.buffer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 10:28 2/11/2023
 **/
public class Demo3 {

    public static void main(String[] args) {

        try (BufferedInputStream in  =  new BufferedInputStream(new FileInputStream("IOTest/a.txt"))){
            // 读取
            byte[] bytes = new byte[1024];
            int readCount;
            StringBuilder sb = new StringBuilder();
            while ((readCount = in.read(bytes)) != -1){
                sb.append(new String(bytes,0,readCount));
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
