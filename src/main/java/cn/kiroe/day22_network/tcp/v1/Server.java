package cn.kiroe.day22_network.tcp.v1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author kiro
 * @description:
 * @data 11:01 7/11/2023
 **/
public class Server {


    public static void main(String[] args) throws IOException {
        // ## 服务端步骤(Server)
        //
        // 1. 创建服务端的socket对象(ServerSocket)
        ServerSocket serverSocket = new ServerSocket(9999);
        // 2. 通过accept建立连接, 得到socket对象
        Socket socket = serverSocket.accept();
        // 3. 从socket中得到输入输出流
        InputStream inputStream = socket.getInputStream();
        // 4. 利用输入输出流进行读写操作
        byte[] bytes =new byte[1024];
        int readCount = 0;
        while ((readCount = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,readCount));
        }

    }

}
