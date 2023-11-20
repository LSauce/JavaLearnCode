package cn.kiroe.day22_network.upd.v2;

import cn.kiroe.day22_network.utils.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author kiro
 * @description:
 * @data 17:47 6/11/2023
 **/
public class Sender {
    public static void main(String[] args) throws IOException {

        // 创建 发送端 socket
        DatagramSocket socket = new DatagramSocket(8888);
        // 把要送的数据 封装成 DatagramPacket
        DatagramPacket sendPacket = NetworkUtils.getSendPacket("哈哈哈", "127.0.0.1", 9999);
        // send
        socket.send(sendPacket);
        // close
        socket.close();
    }
}
