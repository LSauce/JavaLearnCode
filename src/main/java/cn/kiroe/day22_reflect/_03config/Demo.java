package cn.kiroe.day22_reflect._03config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

/**
 * @author kiro
 * @description:
 * @data 16:28 7/11/2023
 **/
public class Demo {

    public static void main(String[] args) throws IOException, SQLException {
        // 创建 properties对象
        Properties properties = new Properties();

        // load(InputStream inStream)        从输入流中读取属性列表（键和元素对）。
        // load(Reader reader)        按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。
        properties.load(Files.newInputStream(Paths.get("src/main/resources/config.properties")));
        // getProperty(String key)        用指定的键在此属性列表中搜索属性。
        String host = properties.getProperty("host");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        System.out.println(host + username + password);
        //
        String url = "jdbc:mysql://"+host+":3306";
        Connection connection = DriverManager.getConnection(url,username,password);
        System.out.println("connection.getClientInfo() = " + connection.getClientInfo());
        System.out.println("connection.getMetaData() = " + connection.getMetaData());
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println("metaData.getDriverName() = " + metaData.getDriverName());

    }
}
