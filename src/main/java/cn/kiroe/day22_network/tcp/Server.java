package cn.kiroe.day22_network.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author kiro
 * @description:
 * @data 14:52 7/11/2023
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(800);
        Socket socket = serverSocket.accept();
        System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
        // try (BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream())) {
        //     byte[] bytes = new byte[1024];
        //     int readCount = 0;
        //     while ((readCount = inputStream.read(bytes)) != -1) {
        //         System.out.println(new String(bytes, 0, readCount));
        //     }
        // }

        File file = new File("IOTest/reply.log");
        FileInputStream inputStream = new FileInputStream(file);
        int readCount;
        byte[] bytes = new byte[1024];
        OutputStream outputStream = socket.getOutputStream();
        while ((readCount = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, readCount);
        }
        outputStream.flush();
        outputStream.close();
        // inputStream.read();
        // String s = "HTTP/1.1 200 OK\n" +
        //         "Date: Sat, 31 Dec 2005 23:59:59 GMT\n" +
        //         "Content-Type: text/html;charset=ISO-8859-1\n" +
        //         "Content-Length: 185\n" +
        //         "\n" +
        //         "\n" +
        //         "<!DOCTYPE html>\n" +
        //         "<html lang=\"en\">\n" +
        //         "<head>\n" +
        //         "    <meta charset=\"UTF-8\">\n" +
        //         "    <title>Title</title>\n" +
        //         "</head>\n" +
        //         "<body>\n" +
        //         "    <h1>test</h1>\n" +
        //         "    <h2 style=\"color: aquamarine\">test2</h2>\n" +
        //         "</body>\n" +
        //         "</html>";


    }
}
