package cn.kiroe.day22_network.utils;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author kiro
 * @description:
 * @data 17:38 6/11/2023
 **/
public class NetworkUtils {
    // 提供一个 用于获取 发送端数据报包的 方法
    public static DatagramPacket getSendPacket(String msg, String ip, int port) throws UnknownHostException {
        // 创建用于发送的 数据报包
        // public DatagramPacket(byte buf[], int offset, int length,
        //                           InetAddress address, int port)

        // 返回一个要发送的包

        return new DatagramPacket(msg.getBytes(),
                0,
                msg.getBytes().length,
                InetAddress.getByName(ip),
                port);
    }

    // 提供 用于接收的 数据报包
    // 放回的为 空包
    public static DatagramPacket getReceivePacket() {
        byte[] bytes = new byte[1024];
        return new DatagramPacket(bytes, 0, bytes.length);
    }

    // 提供一个解析数据的方法
    public static String parseMsg(DatagramPacket packet) {

        return new String(packet.getData(), packet.getOffset(), packet.getLength());
    }
}
