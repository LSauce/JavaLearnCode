package cn.kiroe.day22_network.custom;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

/**
 * @author kiro
 * @description:
 * @data 21:46 7/11/2023
 **/
public class TCPTest {

    public static void main(String[] args) throws IOException {
        File file = new File("IOTest/03.1.1.2&1.1.4 组成与分类.mp4");
        ServerSocket serverSocket = new ServerSocket(8009);
        Socket accept = serverSocket.accept();

        BufferedOutputStream outputStream = new BufferedOutputStream(accept.getOutputStream());
        BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(file.toPath()));
        // 先发送请求头
        String response = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: video/mp4\r\n" +
                "Content-Length: " + file.length() + "\r\n" +
                "Connection: close\r\n\r\n";
        outputStream.write(response.getBytes());
        outputStream.flush();
        byte[] bytes = new byte[10240];
        int readCount;
        while ((readCount = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, readCount);
            outputStream.flush();
        }
        accept.shutdownOutput();
        serverSocket.close();
        inputStream.close();

    }
}
