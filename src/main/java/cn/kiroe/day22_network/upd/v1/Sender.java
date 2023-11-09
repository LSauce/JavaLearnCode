package cn.kiroe.day22_network.upd.v1;

import java.io.IOException;
import java.net.*;

/**
 * @author kiro
 * @description:
 * @data 17:22 6/11/2023
 **/
/*

// 发送端
// 发送端 发送消息 接收端接收消息
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        // 1. 创建发送端的socket对象
        DatagramSocket socket = new DatagramSocket(8888);
        // 2. 把要发送的数据封装成数据报包
        byte[] data = "hello udp".getBytes();
        // 3. send方法发送数据报包
        // DatagramPacket(byte[] buf,  int offset, int length, InetAddress address, int port)
        // 构造数据报包，用来将长度为 length 偏移量为 offset  的包发送到指定主机上的指定端口号
        InetAddress targetIP = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, targetIP, 9999);
        socket.send(packet);
        // 4. 释放资源close
        socket.close();
    }
}
