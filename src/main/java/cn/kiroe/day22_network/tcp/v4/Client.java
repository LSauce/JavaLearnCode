package cn.kiroe.day22_network.tcp.v4;

import java.io.*;
import java.net.Socket;

/**
 * @author kiro
 * @description:
 * @data 11:45 7/11/2023
 **/
public class Client {

    public static void main(String[] args) throws IOException {
        // 建立连接
        Socket socket = new Socket("127.0.0.1", 9999);
        // 尝试获取 输入流
        InputStream inputStream = socket.getInputStream();
        // 读取数据
        byte[] bytes =new byte[1024];
        int readCount;
        File targetFile = new File("IOTest/client.txt");
        // 创建自己的 输出流
        BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(new FileOutputStream(targetFile));
        System.out.println("准备读取");
        // 将数据写入文件中
        while ((readCount = inputStream.read(bytes)) != -1){
            System.out.println("写入到本地中");
            bufferedOutputStream.write(bytes,0,readCount);
            bufferedOutputStream.flush();
        }

        System.out.println("获取结束");

        // 给服务器发送消息
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
        out.write("client发的我获取结束了".getBytes());
        out.flush();
        // close
        bufferedOutputStream.close();
        socket.close();

    }
}
