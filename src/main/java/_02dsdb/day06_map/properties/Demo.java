package _02dsdb.day06_map.properties;

import java.io.IOException;
import java.util.Properties;

/**
 * @author kiro
 * @description:
 * @data 11:44 15/11/2023
 **/
public class Demo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("config.properties"));
        // 使用getProperty() 返回为String
        String username1 = properties.getProperty("username");
        System.out.println("username1 = " + username1);
        // 文件并不会更改
        properties.setProperty("username","test");

        // 不建议使用 get() 返回为 Object
        String username = (String) properties.get("username");
        System.out.println("username = " + username);
        Object password = properties.get("password");
        System.out.println("password = " + password);

    }
}
