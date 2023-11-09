package cn.kiroe.day22_network.tcp.v3;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author kiro
 * @description:
 * @data 11:25 7/11/2023
 **/
public class Client {
    public static void main(String[] args) {

        // 创建Socket对象
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9999);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 获取输出流

        // 写入 对象数据
        try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            out.writeObject(new Student("张三", 99));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // try-with-resource关闭


    }
}
