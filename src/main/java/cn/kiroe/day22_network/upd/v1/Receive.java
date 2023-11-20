package cn.kiroe.day22_network.upd.v1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author kiro
 * @description:
 * @data 17:31 6/11/2023
 **/
public class Receive {

    public static void main(String[] args) throws IOException {
        //DatagramPacket(byte[] buf,  int offset, int length)
        // 构造  DatagramPacket，用来接收长度为 length 的包，在缓冲区中指定了偏移量。

        // 1. 创建接收端的socket对象
        DatagramSocket socket = new DatagramSocket(9999);
        // 2. 创建用于接收的数据报包
        byte[] bytes =new byte[1024];
        // 3. receive方法接收数据
        DatagramPacket packet =new DatagramPacket(bytes,0,bytes.length);
        System.out.println("receive before");
        socket.receive(packet);
        System.out.println("receive after");
        // 4. 解析数据报包
        byte[] data = packet.getData();
        int length = packet.getLength();
        int offset = packet.getOffset();
        System.out.println(new String(data,offset,length));
        // 5. 释放资源close
        socket.close();
    }
}
