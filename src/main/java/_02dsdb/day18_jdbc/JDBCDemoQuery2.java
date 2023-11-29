package _02dsdb.day18_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author Kiro
 * @Date 2023/11/29 11:15
 **/
public class JDBCDemoQuery2 {

    public static void main(String[] args) throws SQLException {
        Connection connection = Demo1Location.getConnection();
        // 查询
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from city;");
        while (resultSet.next()){
            // 只要能进来，说明刚刚经过的这行有数据
            // 有两种传参方式，从1开始,给字段编号
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            System.out.println(id + "_" + name);
        }

        statement.close();
        connection.close();


    }
}
