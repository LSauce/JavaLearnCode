package _02dsdb.day19_JDBC;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @Author Kiro
 * @Date 2023/11/30 09:43
 **/
public class JDBCUtil {
    // 将常量抽取到配置文件中
    // 获取链接
    private static String URL = "jdbc:mysql://192.168.4.16/homework_55th";
    private static String USERNAME = "root";
    private static String PASSWORD = "123321";
    private static String SEPARATOR = "# ------------------";
    private static String DRIVER = "";

    static {
        // 读取properties
        Properties properties = new Properties();
        File file = new File("src/main/java/_02dsdb/day19_JDBC/jdbc.properties");
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        URL = properties.getProperty("URL");
        USERNAME = properties.getProperty("USERNAME");
        PASSWORD = properties.getProperty("PASSWORD");
        SEPARATOR = properties.getProperty("SEPARATOR");
        DRIVER = properties.getProperty("driverClassName");
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // 加载驱动
        Class.forName(DRIVER);
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean close(Connection connection, Statement statement) throws SQLException {
        if (connection == null || statement == null) {
            return false;
        }
        connection.close();
        statement.close();
        return true;
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
     * 读取文件，获取单条SQL
     *
     * @param file
     * @return
     */
    public static List<String> getSQLList(File file) {
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
