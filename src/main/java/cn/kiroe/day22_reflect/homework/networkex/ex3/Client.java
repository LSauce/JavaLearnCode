package cn.kiroe.day22_reflect.homework.networkex.ex3;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

/**
 * @author kiro
 * @description:
 * @data 19:54 7/11/2023
 **/
public class Client {

    public static void main(String[] args) {
        //   c. 客户端文本文件，服务器输出文本文件
        File file = new File("IOTest/client.txt");
        try (Socket socket = new Socket("127.0.0.1",9999);
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new FileReader(file))
        ){
            // 读取并发送
            char[] chars = new char[1024];
            int readCount;
            while ((readCount = reader.read(chars)) != -1){
                writer.write(chars,0,readCount);
                writer.flush();
            }

            // 自动关闭
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
