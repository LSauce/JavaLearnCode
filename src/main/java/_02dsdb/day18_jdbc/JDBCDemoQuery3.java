package _02dsdb.day18_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 1. 点进去，看注释
 * @Author Kiro
 * @Date 2023/11/29 11:36
 **/
public class JDBCDemoQuery3 {

    public static void main(String[] args) throws SQLException {
        Connection connection = Demo1Location.getConnection();
        Statement statement = connection.createStatement();
        // 如果第一个结果是ResultSet对象，则为true ；如果是更新计数或没有结果， fals
        // boolean execute = statement.execute("select * from city");
        boolean execute = statement.execute("delete from city");
        System.out.println("execute = " + execute);

        // 。然后，您必须使用getResultSet或getUpdateCount方法来检索结果
        // ，并使用getMoreResults来移动到任何后续结果。
        if(execute){
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println("resultSet.getString(1) = " + resultSet.getString(2));
            }
        }else{
            System.out.println(statement.getUpdateCount());
        }


    }
}
