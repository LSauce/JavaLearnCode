package _02dsdb.day18_jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

/**
 * @Author Kiro
 * @Date 2023/11/29 10:12
 **/
/*
连接数据库
 */
public class Demo1Location {

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        // 3. 获得 Statement ,用来执行sql
        Statement statement = connection.createStatement();
        // 4. 执行 sql语句
        ResultSet resultSet = statement.executeQuery("select * from book");
        // 5.解析过程
        System.out.println("resultSet = " + resultSet);
        while (resultSet.next()){
            String id = resultSet.getString("id");
            System.out.println("id = " + id);

        }


        // 6.关闭连接
        connection.close();
        statement.close();



    }

    public static Connection getConnection() throws SQLException {
        // 1. 加载驱动
        DriverManager.registerDriver(new Driver());
        // 2. 获得链接
        String url = "jdbc:mysql://192.168.4.16:3306/homework_55th?useSSL=false";
        String user = "root";
        String password = "123321";
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
