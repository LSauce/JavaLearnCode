package _02dsdb.day20_thirdpoll;

import _02dsdb.day19_JDBC.JDBCUtil;
import java.io.File;
import java.sql.*;
import java.util.List;

/**
 * @Author Kiro
 * @Date 2023/12/01 09:59
 **/
public class ExecuteQueryByConnection {
    private static final String SQL_FILE_PATH = "src/main/java/_02dsdb/database/day17_constraint/work1.sql";

    public static void query(Connection connection) throws SQLException {
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
        update(connection);
        insert(connection);
        delete(connection);
        connection.close();

    }

    public static void update(Connection connection) throws SQLException{
        // 进行增删改

        String updateSQL = "update t_stu set name = ? where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
        preparedStatement.setString(1, "修改后");
        preparedStatement.setString(2, "小张");
        preparedStatement.executeUpdate();



    }
    // 进行增加
    public static void insert(Connection connection) throws SQLException {
        String insertSQL = "insert into t_staff values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setString(1,"5");
        preparedStatement.setString(2,"我是名字");
        preparedStatement.setString(3,"教授");
        preparedStatement.setString(4,"人工智能");
        preparedStatement.executeUpdate();


    }

    // 进行删除
    public static void delete(Connection connection) throws SQLException {
        String deleteSql = "delete from t_staff where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
        preparedStatement.setString(1,"我是名字");
        preparedStatement.executeUpdate();
    }

}
