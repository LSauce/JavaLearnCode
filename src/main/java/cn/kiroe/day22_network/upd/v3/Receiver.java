package cn.kiroe.day22_network.upd.v3;

import cn.kiroe.day22_network.utils.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 09:58 7/11/2023
 **/
public class Receiver {

    public static void main(String[] args) throws IOException {
        // 创建接收端的socket对象
        DatagramSocket socket = new DatagramSocket(9999);
        // 输入对象
        Scanner scanner =new Scanner(System.in);
        // while循环
        while (true){
            // 接收逻辑
            // 创建用于 接收的 数据报包
            DatagramPacket receivePacket = NetworkUtils.getReceivePacket();
            // receive
            socket.receive(receivePacket);
            // 解析
            String msg = NetworkUtils.parseMsg(receivePacket);
            System.out.println("接收到了来自:"+receivePacket.getSocketAddress()+
                    "的消息: " +msg);
            // 发送 逻辑
            // 接收阻塞了，发送和接收
            DatagramPacket sendPacket = NetworkUtils.getSendPacket(scanner.nextLine(), "127.0.0.1", 8888);
            socket.send(sendPacket);
            // 接收键盘数据
            // 包
            // 发生
        }

    }
}
