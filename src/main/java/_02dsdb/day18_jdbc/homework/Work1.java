package _02dsdb.day18_jdbc.homework;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static _02dsdb.day18_jdbc.homework.JDBCUtils.executeSQLFile;

/**
 * @Author Kiro
 * @Date 2023/11/29 13:56
 **/
public class Work1 {
    private static final String SQL_FILE_PATH = "src/main/java/_02dsdb/database/day17_constraint/work1.sql";

    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        // 读取文件 获取 sql字符串
        File file = new File(SQL_FILE_PATH);
        executeSQLFile(file, statement);
        statement.close();
        connection.close();
    }



}
