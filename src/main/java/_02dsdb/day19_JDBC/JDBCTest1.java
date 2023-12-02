package _02dsdb.day19_JDBC;

import _02dsdb.day18_jdbc.homework.JDBCUtils;
import com.mysql.cj.jdbc.Driver;

import java.io.File;
import java.sql.*;
import java.util.List;


/**
 * @Author Kiro
 * @Date 2023/11/29 13:56
 **/
public class JDBCTest1 {
    private static final String SQL_FILE_PATH = "src/main/java/_02dsdb/database/day17_constraint/work1.sql";

    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        // 读取文件 获取 sql字符串
        File file = new File(SQL_FILE_PATH);
        // 执行并打印
        List<String> sqlList = JDBCUtil.getSQLList(file);
        // 执行
        for (String sql : sqlList) {
            ResultSet resultSet = statement.executeQuery(sql);
            JDBCUtil.printResultSet(resultSet);
        }
        // resultSet 只是游标，不包括结果
        JDBCUtil.close(connection,statement);
    }









}
