package cn.kiroe.day22_network.tcp.v4;


import java.io.*;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

/**
 * @author kiro
 * @description:
 * @data 11:42 7/11/2023
 **/
/*

发送文件给 客户端
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();


        File file = new File("IOTest/reply.log");
        // 读取
        try (BufferedOutputStream outputStream1 = new BufferedOutputStream(outputStream); BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(file.toPath()))) {
            byte[] bytes = new byte[1024];
            int readCount;
            // 写入
            while ((readCount = inputStream.read(bytes)) != -1) {
                System.out.println("写入到客户端中");
                outputStream1.write(bytes, 0, readCount);
                outputStream1.flush();
            }
            // 链接输出流 半关闭，因为 无法探知 文件是否传输结束
            socket.shutdownOutput();
            // 给接收 客户端的反馈
            // 从socket中获取输出流
            InputStream inputStream2 = socket.getInputStream();
            byte[] bytes2 = new byte[1024];
            int readCount2 = 0;
            BufferedInputStream bufferedInputStream =new BufferedInputStream(inputStream2);
            while((readCount2 = bufferedInputStream.read(bytes2) )!= -1){
                System.out.println(new String(bytes2,0,readCount2));
            }

        }

        // 传输完毕
        socket.close();


    }
}
