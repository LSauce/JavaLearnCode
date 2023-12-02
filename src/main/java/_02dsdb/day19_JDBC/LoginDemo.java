package _02dsdb.day19_JDBC;

import java.sql.*;

/**
 * SQL 注入，把用户的数据，直接拼接，可能有关键词
 * 如果没处理，mysql会将 会将 用户输入的 关键词直接执行，会有安全问题
 * @Author Kiro
 * @Date 2023/11/30 10:28
 **/
public class LoginDemo {
    private static String username = "user";
    private static String password = "password";


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        preparedStatementTest(" 'OR '1'='1 ");
    }

    public static boolean preparedStatementTest(String id) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * 1from city where id = ?");
        preparedStatement.setString(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        String test = "test";
        System.out.println(test);
        JDBCUtil.printResultSet(resultSet);
        return true;
    }
}
