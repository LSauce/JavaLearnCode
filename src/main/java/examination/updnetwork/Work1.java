package examination.updnetwork;


import java.io.IOException;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kiro
 * @description:
 * @data 19:56 8/11/2023
 **/
/*
编写一个UDP发送端，该发送端向接收端发送一条表示出生日期的字符串，
格式是"yyyy-MM-dd"。
接收端获取这个字符串以后，计算一下这个出生日期到现在的天数之差，
并将这个天数之差返还给发送端（可以以字符串的形式返还）。
发送端在接收到这个天数差后，
打印一下这个天数差，打印的格式是："你已经出生了xxx天"
 */
public class Work1 {
}

class Send {

    public static void main(String[] args) {
        // 编写一个UDP发送端，该发送端向接收端发送一条表示出生日期的字符串，格式是"yyyy-MM-dd"。
        DatagramSocket socket = null;
        String ip = "127.0.01";
        try {
            socket = new DatagramSocket(8888);
            // 创建信息
            String birthDay = "2001-08-17";
            // 创建报文
            byte[] bytes = birthDay.getBytes();
            InetAddress targetIP = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, targetIP, 9999);

            // 发送报文
            socket.send(packet);
            // 发送端在接收到这个天数差后，
            // 打印一下这个天数差，打印的格式是："你已经出生了xxx天"
            // 接收报文
            byte[] bytes1 = new byte[1024];
            DatagramPacket packet1 = new DatagramPacket(bytes1, 0, bytes1.length);
            // 获取报文
            socket.receive(packet1);
            String day = new String(packet1.getData(), packet1.getOffset(), packet1.getLength());
            System.out.println("你已经出生了" + day + "天");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
        // 发送端在接收到这个天数差后，
        // 打印一下这个天数差，打印的格式是："你已经出生了xxx天"
    }

}

class Receiver {

    public static void main(String[] args) {
        // 接收端获取这个字符串以后，计算一下这个出生日期到现在的天数之差，

        // 并将这个天数之差返还给发送端（可以以字符串的形式返还）。

        DatagramSocket socket = null;
        String ip = "127.0.01";
        try {
            socket = new DatagramSocket(9999);

            // 接收报文
            byte[] bytes1 = new byte[1024];
            DatagramPacket packet1 = new DatagramPacket(bytes1, 0, bytes1.length);
            // 获取报文
            socket.receive(packet1);
            // 获取报文信息:
            byte[] data = packet1.getData();
            // 获取信息
            String birthDay = new String(data, packet1.getOffset(), packet1.getLength());
            // 获得天数
            int day = getDayFromBirthDay(birthDay);
            // 创建报文
            byte[] bytes = ("" + day).getBytes();
            InetAddress targetIP = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, targetIP, 8888);
            // 发送报文
            socket.send(packet);
            // 发送端在接收到这个天数差后，
            // 打印一下这个天数差，打印的格式是："你已经出生了xxx天"

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    private static int getDayFromBirthDay(String birthDay) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(birthDay);
        return calcBornDays(parse);
    }

    private static int calcBornDays(Date bornday) {

        // 计算一共来了多少天
        long livingMillis = System.currentTimeMillis() - bornday.getTime();
        int livedDay = (int) (livingMillis / 1000 / 60 / 60 / 24);

        return livedDay;

    }

}
