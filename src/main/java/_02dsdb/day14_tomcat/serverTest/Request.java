package _02dsdb.day14_tomcat.serverTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Reqeust
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2022/10/24 16:07
 * @Version V1.0
 **/
public class Request {

    private String requestMessage;

    private String method;

    private String requestURI;

    private String protocol;
    private Map<String, String> requestHeaders = new HashMap<>();

    public Request(Socket client) {
        parseRequest(client);
        parseRequestLine();
        parseRequestHeader();
    }

    public String getMethod() {
        return method;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHeader(String headerName) {
        return requestHeaders.get(headerName);
    }

    public Set<String> getHeaderNames() {
        return requestHeaders.keySet();
    }

    /**
     * 解析请求报文的请求头部分
     * 如何解析？请求头开始的标志：\r\n   请求头结束的标志：\r\n\r\n
     * 解析之后的请求头存放在哪？map
     */
    private void parseRequestHeader() {
        int begin = requestMessage.indexOf("\r\n");
        int end = requestMessage.indexOf("\r\n\r\n");
        String header = requestMessage.substring(begin + 2, end);
        String[] split = header.split("\r\n");
        for (String s : split) {
            int index = s.indexOf(":");
            String key = s.substring(0, index).trim();
            String value = s.substring(index + 1).trim();
            requestHeaders.put(key, value);
        }
    }

    /**
     * 解析请求报文的请求行部分  GET /2.html HTTP/1.1\r\n
     */
    private void parseRequestLine() {
        int index = requestMessage.indexOf("\r\n");
        // GET /2.html HTTP/1.1
        String line = requestMessage.substring(0, index);
        String[] parts = line.split(" ");
        this.method = parts[0];
        this.requestURI = parts[1];
        this.protocol = parts[2];
    }

    private void parseRequest(Socket client) {
        InputStream inputStream = null;
        try {
            inputStream = client.getInputStream();
            byte[] bytes = new byte[1024];
            // note：下面read这一步不要再循环里面读取
            int length = inputStream.read(bytes);
            this.requestMessage = new String(bytes, 0, length);
            System.out.println(requestMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


