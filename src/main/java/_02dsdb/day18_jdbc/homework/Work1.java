package _02dsdb.day18_jdbc.homework;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Kiro
 * @Date 2023/11/29 13:56
 **/
public class Work1 {
    private static final String SQL_FILE_PATH = "src/main/java/_02dsdb/database/day17_constraint/work1.sql";
    private static final String SEPARATOR = "# ------------------";
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        // testPrint(statement, "select * from city");

        // 读取文件 获取 sql字符串
        File file = new File(SQL_FILE_PATH);
        executeSQLFile(file, statement);


        statement.close();
        connection.close();
    }

    /**
     * 执行 SQL文件中查询
     * 查询之间使用 # ------------------ 分隔
     * 不执行第一条分隔 之前的内容
     * @param file
     * @param statement
     * @throws SQLException
     */

    private static void executeSQLFile(File file, Statement statement) throws SQLException {
        List<String> sqlList = getSQList(file);
        // 执行 sql,并打印结果
        for (String sql : sqlList) {
            System.out.println(sql);
            testPrint(statement, sql);
        }
    }

    /**
     * 测试打印
     * @param statement
     * @param sql
     * @throws SQLException
     */
    private static void testPrint(Statement statement, String sql) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);
        JDBCUtils.printResultSet(resultSet);
        resultSet.close();
    }

    /**
     * 读取文件，获取单条SQL
     * @param file
     * @return
     */

    private static List<String> getSQList(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            StringBuilder sb = new StringBuilder();
            char[] chars = new char[1024];
            int readCount;
            while ((readCount = reader.read(chars)) != -1){
                sb.append(chars,0,readCount);
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
