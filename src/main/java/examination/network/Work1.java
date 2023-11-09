package examination.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 19:30 8/11/2023
 **/

/*
使用TCP网络编程完成用户登录功能：

客户端启动后提示键盘录入，控制台输入用户名和密码后，向服务器发出登录请求，此时发送的是一个User对象，而不是两个字符串；

服务端接收到User对象后进行判断，如果用户名和密码均是admin，则登录成功，否则登录失败。不管登录是否成功，都需要返回相应响应信息，服务端结束；

客户端接收响应后打印信息，输出登录结果，客户端结束。

1)用户User类已提供构造方法 public User(String username,String password)。

2)客户端采用ObjectOutputStream发送封装了用户名和密码的User对象。

3)服务器端和客户端的类名和方法声明如下所示。

public class LoginServer {
	public static void main(String[] args) throws Exception {}
}

public class LoginClient {
	public static void main(String[] args) throws Exception {}
 */
public class Work1 {
    public static void main(String[] args) {

    }


}
/*
服务端接收到User对象后进行判断，
如果用户名和密码均是admin，则登录成功，否则登录失败。
不管登录是否成功，都需要返回相应响应信息，服务端结束；

 */
class LoginServer {
    public static void main(String[] args)  {
        String username = "admin";
        String password = "admin";

        // 接受数据，然后回复
        try (ServerSocket serverSocket =new ServerSocket(8888);
             Socket socket = serverSocket.accept();
             ObjectInputStream objectInputStream =new ObjectInputStream(socket.getInputStream());
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))
        ){
            Object o = objectInputStream.readObject();
            String replyMsg = "";
            if(o instanceof User){
                // 读取数据
                User user = (User)o;
                // 如果密码作为
                if(username.equals(user.username) && password.equals(user.password)){
                    replyMsg = "登入成功";
                }else {
                    replyMsg = "登入失败";
                }

            }else {
                replyMsg = "发送对象数据错误";
            }

            // 发送数据
            writer.write(replyMsg);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/*
客户端启动后提示键盘录入，控制台输入用户名和密码后，
向服务器发出登录请求，此时发送的是一个User对象，
而不是两个字符串；

 */
class LoginClient {
    public static void main(String[] args) {

      // 客户端接收响应后打印信息，输出登录结果，客户端结束。
        // 2)客户端采用ObjectOutputStream发送封装了用户名和密码的User对象。
        String serverIp = "127.0.0.1";
        int port = 8888;
        // 输入登入信息
        try(Scanner in = new Scanner(System.in);
            Socket socket =new Socket(serverIp,port);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            // 输入对象
            String username = in.nextLine();
            String password = in.nextLine();
            User user = new User(username, password);
            // 发送对象
            System.out.println("发送对象");

            outputStream.writeObject(user);
            socket.shutdownOutput();
            // 输出登入结果
            char[] chars = new char[1024];
            int readCount = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while ((readCount = reader.read(chars)) != -1){
                stringBuilder.append(new String(chars,0,readCount));
            }
            System.out.println("服务端回复为："+stringBuilder);

        } catch (UnknownHostException e) {
           e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}

// 1)用户User类已提供构造方法 public User(String username,String password)。
class User implements Serializable{
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

