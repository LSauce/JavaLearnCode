package cn.kiroe.day22_network.tcp.v1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author kiro
 * @description:
 * @data 10:57 7/11/2023
 **/

/*
## 客户端步骤(Client)

1. 创建客户端Socket对象
2. 从socket中获取输入输出流
3. 利用输出输出流进行读写操作
4. 释放资源close
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // ## 客户端步骤(Client)
        // 1. 创建客户端Socket对象
        Socket socket = new Socket("127.0.0.1",9999);
        // 2. 从socket中获取输入输出流
        OutputStream outputStream = socket.getOutputStream();
        // 3. 利用输出输出流进行读写操作
        outputStream.write("hello".getBytes());
        outputStream.flush();
        // 4. 释放资源close
        socket.close();
    }
}
