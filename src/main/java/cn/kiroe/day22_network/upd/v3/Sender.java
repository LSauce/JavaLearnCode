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
 * @data 09:56 7/11/2023
 **/
/*
使用 Scanner 交互回复的 Sender
 */
public class Sender {

    public static void main(String[] args) throws IOException {
        // 创建发送端的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        // 创建scanner对象
        Scanner scanner = new Scanner(System.in);
        // while循环
        while (true) {
            // 发送逻辑
            // 先接收键盘数据
            String s = scanner.nextLine();
            // 把要发送的数据封装成数据报包
            DatagramPacket sendPacket =
                    NetworkUtils.getSendPacket(s, "127.0.0.1", 9999);
            // send
            datagramSocket.send(sendPacket);

            // 接收逻辑
            // 创建用于接收的数据报包
            DatagramPacket receivePacket = NetworkUtils.getReceivePacket();
            // receive接收
            datagramSocket.receive(receivePacket);
            // 解析
            String msg = NetworkUtils.parseMsg(receivePacket);
            // 打印
            System.out.println("接收到了来自:"+receivePacket.getSocketAddress()+
                    "的消息: " +msg);
        }

    }
}
