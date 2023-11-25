package _02dsdb.day14_tomcat.serverTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kiro
 * @description:
 * @data 16:05 24/11/2023
 **/
public class Request2 {
    /*

    解析 http请求
     */
    public String requestName;

    public String methodName;

    public String protocol;

    public Map<String,String> requestHeaderMap = new HashMap<>();

    public Request2(InputStream inputStream) throws IOException {
        String content = getContent(inputStream);
        processFirstLine(content);
        processHeaders(content);

    }

    private void processHeaders(String content) {
        // Host: 127.0.0.1:9000
        // Connection: keep-alive
        // Cache-Control: max-age=0
        // sec-ch-ua: "Google Chrome";v="119", "Chromium";v="119", "Not?A_Brand";v="24"
        // sec-ch-ua-mobile: ?0
        // sec-ch-ua-platform: "macOS"
        // Upgrade-Insecure-Requests: 1

        int firstIndex =  content.indexOf("\r\n") + 2;
        int lastIndex = content.indexOf("\r\n\r\n");

        String headerContent = content.substring(firstIndex,lastIndex);
        String[] eachHeaderLine = headerContent.split("\r\n");
        for (String s : eachHeaderLine) {
            String[] headerNameAndValue = s.split(": ");
            this.requestHeaderMap.put(headerNameAndValue[0],headerNameAndValue[1]);
        }
    }

    private void processFirstLine(String content) {
        String[] split = content.split("\r\n");
        // GET /1.txt HTTP/1.1
        String firstLine = split[0];
        String[] split1 = firstLine.split(" ");
        this.methodName = split1[0];
        this.requestName = split1[1];
        this.protocol = split1[2];

    }

    private static String getContent(InputStream inputStream) throws IOException {
        // 传入inputStream，将inputStream的内容 解析出来
        byte[] bytes = new byte[20480];
        int len = inputStream.available();
        inputStream.read(bytes,0,len);
        return new String(bytes,0,len);
    }

    public static void main(String[] args) {

    }
}
