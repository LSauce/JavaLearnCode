package _02dsdb.day18_jdbc.homework;

import com.mysql.cj.jdbc.Driver;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Kiro
 * @Date 2023/11/29 13:56
 **/
public class JDBCUtils {
    // 获取链接
    private final static String URL = "jdbc:mysql://192.168.4.16/homework_55th";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "123321";

    private static final String SEPARATOR = "# ------------------";


    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new Driver());
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 打印ResultSet结果
     *
     * @param resultSet
     * @throws SQLException
     */

    public static void printResultSet(ResultSet resultSet) throws SQLException {
        printlnColumn(resultSet);// 打印行数
        printResultSetContent(resultSet);// 打印内容
    }

    /**
     * 打印Result数据内容
     *
     * @param resultSet
     * @throws SQLException
     */
    private static void printResultSetContent(ResultSet resultSet) throws SQLException {
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getString(i) + "\t");

            }
            System.out.println();
        }
    }

    /**
     * 打印 字段行
     *
     * @param resultSet
     * @throws SQLException
     */
    private static void printlnColumn(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(metaData.getColumnName(i) + "\t");
        }
        System.out.println();
    }



    /**
     * 执行 SQL文件中查询
     * 查询之间使用 # ------------------ 分隔
     * 不执行第一条分隔 之前的内容
     *
     * @param file
     * @param statement
     * @throws SQLException
     */

    public static void executeSQLFile(File file, Statement statement) throws SQLException {
        List<String> sqlList = getSQList(file);
        // 执行 sql,并打印结果
        for (String sql : sqlList) {
            System.out.println(sql);
            JDBCUtils.printResultSet(statement.executeQuery(sql));
        }
    }


    /**
     * 读取文件，获取单条SQL
     *
     * @param file
     * @return
     */
    public static List<String> getSQList(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            char[] chars = new char[1024];
            int readCount;
            while ((readCount = reader.read(chars)) != -1) {
                sb.append(chars, 0, readCount);
            }
            String[] sqlArray = sb.toString().split(SEPARATOR);
            ArrayList<String> sqlList = new ArrayList<>(Arrays.asList(sqlArray));

            sqlList.remove(0);// 舍去开头的
            return sqlList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
