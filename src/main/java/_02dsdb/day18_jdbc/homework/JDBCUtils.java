package _02dsdb.day18_jdbc.homework;

import java.sql.*;

/**
 * @Author Kiro
 * @Date 2023/11/29 13:56
 **/
public class JDBCUtils {
    // 获取链接
    private final static String URL = "jdbc:mysql://192.168.4.16/homework_55th";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "123321";

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 打印ResultSet结果
     * @param resultSet
     * @throws SQLException
     */

    public static void printResultSet(ResultSet resultSet) throws SQLException {
        printlnColumn(resultSet);// 打印行数
        printResultSetContent(resultSet);// 打印内容
    }

    /**
     * 打印Result数据内容
     * @param resultSet
     * @throws SQLException
     */
    private static void printResultSetContent(ResultSet resultSet) throws SQLException {
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()){
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getString(i)+"\t");

            }
            System.out.println();
        }
    }

    /**
     * 打印 字段行
     * @param resultSet
     * @throws SQLException
     */
    private static void printlnColumn(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(metaData.getColumnName(i)+"\t");
        }
        System.out.println();
    }
}
