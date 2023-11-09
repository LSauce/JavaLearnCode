package cn.kiroe.day22_reflect.homework.networkex.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

/**
 * @author kiro
 * @description:
 * @data 19:51 7/11/2023
 **/
public class Server {

    public static void main(String[] args) {
        // b. 客户端文本文件，服务器输出到控制台
        try (ServerSocket serverSocket = new ServerSocket(9999);
             BufferedReader reader = new BufferedReader(new InputStreamReader(serverSocket.accept().getInputStream()))
        ) {
            char[] chars = new char[1024];
            int readCount;
            while ((readCount = reader.read(chars)) != -1){
                // 输出到 控制台
                System.out.print(new String(chars,0,readCount));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
