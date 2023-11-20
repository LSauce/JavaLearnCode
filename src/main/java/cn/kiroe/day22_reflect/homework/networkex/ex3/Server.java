package cn.kiroe.day22_reflect.homework.networkex.ex3;

import java.io.*;
import java.net.ServerSocket;

/**
 * @author kiro
 * @description:
 * @data 19:58 7/11/2023
 **/
public class Server {

    public static void main(String[] args) {
        //  c. 客户端文本文件，服务器输出文本文件
        File file= new File("IOTest/server.txt");
        try (ServerSocket serverSocket = new ServerSocket(9999);
             BufferedReader reader = new BufferedReader(new InputStreamReader(serverSocket.accept().getInputStream()));
             PrintWriter writer = new PrintWriter(file)
        ){
            // 接受消息
            char[] chars = new char[1024];
            int readCount;
            while ((readCount = reader.read(chars)) != -1){
                writer.write(chars,0,readCount);
                writer.flush();
            }

            // 自动关闭
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
