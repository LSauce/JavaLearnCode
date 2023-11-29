package _02dsdb.day18_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author Kiro
 * @Date 2023/11/29 11:15
 **/
public class JDBCDemoQuery {

    public static void main(String[] args) throws SQLException {
        Connection connection = Demo1Location.getConnection();
        // 查询
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from city;");
        while (resultSet.next()){
            // 只要能进来，说明刚刚经过的这行有数据
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            System.out.println(id + "_" + name);
        }

        statement.close();
        connection.close();


    }
}
