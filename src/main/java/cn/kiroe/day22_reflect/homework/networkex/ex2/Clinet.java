package cn.kiroe.day22_reflect.homework.networkex.ex2;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author kiro
 * @description:
 * @data 19:46 7/11/2023
 **/
public class Clinet {
    public static void main(String[] args) {
        //  b. 客户端文本文件，服务器输出到控制台
        File file = new File("IOTest/client.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             Socket socket = new Socket("127.0.0.1", 9999);
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            // 读取文本，并发送给 服务器
            char[] chars = new char[1024];
            int readCount;
            while ((readCount = reader.read(chars)) != -1){
                writer.write(chars,0,readCount);
                writer.flush();
            }
            // 自动关闭
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
