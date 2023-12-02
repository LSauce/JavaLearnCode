package _02dsdb.day19_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author Kiro
 * @Date 2023/11/30 10:57
 **/
public class LoginDemo3 {

    public static void main(String[] args) {
        try (Connection connection = JDBCUtil.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from city where id = ? AND name = ?");
            preparedStatement.setString(1,"7");
            preparedStatement.setString(2,"test");
            ResultSet resultSet = preparedStatement.executeQuery();
            JDBCUtil.printResultSet(resultSet);


            // 什么是数据库注入问题
            // 用户通过刻意的 输入，从而绕过延保的SQL，或者执行新sql，要先发给数据库 对 未添加的变量的sql，进行预编译，然后返回给程序

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
