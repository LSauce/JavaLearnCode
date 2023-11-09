package cn.kiroe.day22_network.upd.v4;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kiro
 * @description:
 * @data 10:11 7/11/2023
 **/
public class OtherPerson {

    public static void main(String[] args) throws SocketException {
        // 创建用于接收于发送的 socket对象
        DatagramSocket socket = new DatagramSocket(9999);
        // 创建两个任务 一个发送，一个接受
        SendTask sendTask = new SendTask("192.168.4.255", 8888, socket);
        ReceiveTask receiveTask = new ReceiveTask(socket);
        // 运作在两个线程中
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(sendTask);
        service.submit(receiveTask);


    }
}
