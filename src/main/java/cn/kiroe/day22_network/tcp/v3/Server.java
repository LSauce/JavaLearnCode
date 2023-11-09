package cn.kiroe.day22_network.tcp.v3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author kiro
 * @description:
 * @data 11:28 7/11/2023
 **/
public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 创建 ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(9999);
        // 获取接受 socket对象
        Socket socket = serverSocket.accept();
        // 获取 输入流对象
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        // 读取对象数据
        Student student = (Student) objectInputStream.readObject();
        System.out.println("student = " + student);
        // 关闭 流资源
        objectInputStream.close();
        socket.close();
    }
}
