package cn.kiroe.day22_network.tcp.v2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kiro
 * @description:
 * @data 11:09 7/11/2023
 **/
public class Server {

    public static void main(String[] args) throws IOException {

        // 创建 ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(9999);
        // while接收新的链接
        while (true) {
            // 得到socket对象
            Socket accept = serverSocket.accept();
            ExecutorService service = Executors.newCachedThreadPool();
            service.submit(new acceptDeal(accept));

        }

    }


}

class acceptDeal implements Runnable {
    private Socket accept;

    public acceptDeal(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run() {
        try {
            dealAccept(accept);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dealAccept(Socket accept) throws IOException {
        // 获取输入流
        System.out.println("已连接"+ accept);
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int readCount = 0;
        StringBuilder sb = new StringBuilder();
        while ((readCount = inputStream.read(bytes)) != -1) { // 这里会阻塞
            String msg = new String(bytes, 0, readCount);
            sb.append(accept.getInetAddress()+" "+msg + System.lineSeparator());
            System.out.println(accept.getInetAddress()+msg);
        }

        System.out.println(accept.getInetAddress() + ": " + sb);
    }
}
