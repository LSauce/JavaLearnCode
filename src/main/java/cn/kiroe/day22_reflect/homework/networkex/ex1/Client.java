package cn.kiroe.day22_reflect.homework.networkex.ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 19:27 7/11/2023
 **/

/*
2.参考上课代码实现
    a. 客户端键盘录入，服务器输出文本文件
    b. 客户端文本文件，服务器输出到控制台
    c. 客户端文本文件，服务器输出文本文件
 */
public class Client {

    public static void main(String[] args) {
        //  a. 客户端键盘录入，服务器输出文本文件
        // 创建Socket
        try (Socket socket = new Socket("127.0.0.1", 9999);
             PrintWriter writer = new PrintWriter(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in);) {
            // 键盘录入
            System.out.println("请输入要向服务器发送的信息");



            String input ;
            // 当输入 end是 结束
            while (!(input = scanner.nextLine()).equals("end")){
                // 发送信息
                writer.println(input);
                writer.flush(); // 排空缓存
            }
            // 结束发送
            socket.shutdownOutput();
            // 自动close
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
