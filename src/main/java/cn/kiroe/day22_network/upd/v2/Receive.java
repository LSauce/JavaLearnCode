package cn.kiroe.day22_network.upd.v2;

import cn.kiroe.day22_network.utils.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author kiro
 * @description:
 * @data 17:49 6/11/2023
 **/
public class Receive {

    public static void main(String[] args) throws IOException {
        // 创建socket对象
        DatagramSocket socket = new DatagramSocket(9999);
        // 创建用具接收的数据报包
        DatagramPacket receivePacket = NetworkUtils.getReceivePacket();
        // 接收
        socket.receive(receivePacket);
        // 解析数据
        String response = NetworkUtils.parseMsg(receivePacket);
        System.out.println(response);
        socket.close();
    }
}
