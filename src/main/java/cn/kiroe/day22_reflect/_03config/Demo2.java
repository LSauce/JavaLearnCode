package cn.kiroe.day22_reflect._03config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author kiro
 * @description:
 * @data 16:50 7/11/2023
 **/
public class Demo2 {

    public static void main(String[] args) throws IOException {
        System.out.println("ClassLoader.getSystemResource(\"\") = " + ClassLoader.getSystemResource(""));
        // 通过类加载器 加载配置文件
        // 只是获取流的方式 不一样
        InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(systemResourceAsStream);
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

    }
}
