package cn.kiroe.day22_network.tcp.v2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 11:07 7/11/2023
 **/
public class Client {

    public static void main(String[] args) throws IOException {
        // 创建Socket对象
        Socket socket = new Socket("127.0.0.1", 9999);
        // 创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        while (true){
            String msg = scanner.nextLine();
            // socket获取输出流
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(msg.getBytes());


        }

    }
}
