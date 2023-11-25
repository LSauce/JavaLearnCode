package _02dsdb.day14_tomcat.serverTest;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 15:10 24/11/2023
 **/

/*

服务器程序：持续不断地监听某一端口号；如果客户端往当前端口号发送请求，那么服务器需要做出响应。

要求：涉及协议的部分需要掌握，其他部分根据自己的情况来。

手写服务器，接收请求，然后  1.html   2.txt  返回这种东西。
 */
public class Server {

    public static void main(String[] args) throws IOException {

            ServerSocket serverSocket = new ServerSocket(9000);

        while (true) {
            // 获取链接
            Socket socket = serverSocket.accept();
            // 手写服务器，接收请求，然后  1.html   2.txt  返回这种东西。
            // 读取文件，然后发送
            BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
            int readInt = 0;
            byte[] bytes = new byte[20480];
            StringBuilder sb = new StringBuilder();
            int readCount = inputStream.read(bytes);
            System.out.println(readCount);
            sb.append(new String(bytes, 0, readCount));
            System.out.println(sb);
            // 获取 每行
            String[] splitLines = sb.toString().split(System.lineSeparator());
            System.out.println("splitLines = " + Arrays.toString(splitLines));
            File file = new File("IOTest/c2.html");
            // 发送文件
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
            char[] chars = new char[(int) file.length()];
            int read = reader1.read(chars);
            String s = new String(chars, 0, read);
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n" +
                    "\r\n" +
                    "<html><body><h1>Hello, World!</h1></body></html>";
            String response2 = "HTTP/1.1 200 OK" + System.lineSeparator() +
                    "Server: tomcat" + System.lineSeparator() +
                    "Content-Language: zh-CN" + System.lineSeparator() +
                    "milkTea: cyys";
            System.out.println(s);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            String response3 = "HTTP/1.1 404 NotFound" + System.lineSeparator() +
                    "Server: tomcat" + System.lineSeparator() +
                    "Content-Language: zh-CN" + System.lineSeparator() +
                    "milkTea: cyys";
            printWriter.print(response3);
            printWriter.print(s);

            printWriter.close();
        }

    }
}

class Client {
    public static void main(String[] args) throws IOException {
        String serverName = "127.0.0.1";
        int port = 9000;
        Socket socket = new Socket(serverName, port);
        OutputStream outputStream = socket.getOutputStream();
        // 获得输入,让他输入
        InputStream inputStream = new BufferedInputStream(socket.getInputStream());
        int readInt = 0;

    }
}
