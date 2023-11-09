package cn.kiroe.day22_network.upd.v4;

import cn.kiroe.day22_network.utils.NetworkUtils;
import sun.nio.ch.Net;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kiro
 * @description:
 * @data 10:11 7/11/2023
 **/
// 发送 于 接收 位于 连个进程
public class OnePerson {

    public static void main(String[] args) throws SocketException {
        // 创建用于接收于发送的 socket对象
        DatagramSocket socket = new DatagramSocket(8888);

        // 创建两个任务 一个发送，一个接受
        SendTask sendTask = new SendTask("127.0.0.1", 9999, socket);

        ReceiveTask receiveTask = new ReceiveTask(socket);
        // 运作在两个线程中
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(sendTask);
        service.submit(receiveTask);


    }


}


class SendTask implements Runnable{
    String ip;
    int port;

    private  DatagramSocket socket;

    public SendTask(String ip, int port, DatagramSocket socket) {
        this.ip = ip;
        this.port = port;
        this.socket = socket;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("发送运行中");

            Scanner scanner =new Scanner(System.in);
            String msg = scanner.next();
            try {
                socket.send(NetworkUtils.getSendPacket(msg,ip,port));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class ReceiveTask implements Runnable{
    private  DatagramSocket socket;

    public ReceiveTask(DatagramSocket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        while (true){

            System.out.println("接收运行中");
            DatagramPacket receivePacket = NetworkUtils.getReceivePacket();
            try {
                socket.receive(receivePacket);
                String s = NetworkUtils.parseMsg(receivePacket);
                System.out.println("收到"+ receivePacket.getAddress() +":"+receivePacket.getPort()+ "的消息:" + s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 如果 接收到的 ip 不同，则 创建新 的 Sock


        }
    }
}

class DatagramSocketObject{
    public static volatile DatagramSocket socket;
}
