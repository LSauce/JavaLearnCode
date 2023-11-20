package cn.kiroe.day22_reflect.homework.networkex.ex1;

import java.io.*;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;

/**
 * @author kiro
 * @description:
 * @data 19:31 7/11/2023
 **/
public class Server {

    public static void main(String[] args) {
        //  a. 客户端键盘录入，服务器输出文本文件
        // 获取客户端文本，输出为文件
        // 使用InputStreamReader 转换流
        File file = new File("IOTest/serverRevices");
        try (ServerSocket serverSocket = new ServerSocket(9999);
             PrintWriter writer = new PrintWriter(file);
             Socket accpetSocket = serverSocket.accept();
             BufferedReader reader = new BufferedReader(new InputStreamReader(accpetSocket.getInputStream()))
        ) {
            // 获取信息
            char[] chars = new char[1024];
            int readCount;
            while ((readCount = reader.read(chars)) != -1) {
                // 写入数据
                writer.write(chars, 0, readCount);
                writer.flush();
            }
            // 自动关闭
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
