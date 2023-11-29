package _02dsdb.day18_jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author Kiro
 * @Date 2023/11/29 11:02
 **/
public class JDBCDemoDelete {
    public static void main(String[] args) throws SQLException {
        // 1.加载驱动
        // DriverManager.registerDriver(new Driver()); // 有spi机制，不用 加载也行了
        // 2. 获取链接
        String url = "jdbc:mysql://192.168.4.16:3306/homework_55th";
        String username = "root";
        String password = "123321";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3.获取Statement对象
        Statement statement = connection.createStatement();
        // 4.执行SQL,5的
        // 插入数据
        int i = statement.executeUpdate("insert into city(id,name,province_id) values (7,'test',41)");
        System.out.println("i = " + i);

        // 删除数据
        int i1 = statement.executeUpdate("delete from city where id = '7'");
        System.out.println("i1 = " + i1);
        // 更新
        int update = statement.executeUpdate("update city set id = 1000, name = 'test' where id=6");
        System.out.println("update = " + update);

        // 6.关闭连接
        statement.close();
        connection.close();
    }
}
