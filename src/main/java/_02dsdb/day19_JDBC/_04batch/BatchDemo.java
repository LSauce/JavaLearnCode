package _02dsdb.day19_JDBC._04batch;

import _02dsdb.day19_JDBC.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static _02dsdb.day19_JDBC.JDBCUtil.*;

/**
 * @Author Kiro
 * @Date 2023/11/30 11:05
 **/
public class BatchDemo {
     Connection connection;

    {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    }

    @Test
    public  void batchUserFor0() throws SQLException {
        Statement statement = connection.createStatement();
        for (int i = 0; i < 5000; i++) {
            statement.executeUpdate("insert into city(id, name) values ( "+i+",'name"+ i+"')");
        }
        JDBCUtil.close(connection,statement);

    }
    @Test
    public  void batchUserFor() throws SQLException {
        Statement statement = connection.createStatement();
        for (int i = 0; i < 5000; i++) {
            statement.addBatch("insert into city(id, name) values ( "+i+",'name"+ i+"')");
        }
        statement.executeBatch();
        JDBCUtil.close(connection,statement);

    }

    @Test
    public  void batchUsePreparedStatement() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into city(id, name) values ( ?,?)");
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1,i+"");
            preparedStatement.setString(2,"name"+i);
            preparedStatement.addBatch();
        }
        // 打开rewriteBatchedStatements=true会重写sql，批处理sql

        preparedStatement.executeBatch();
        JDBCUtil.close(connection,preparedStatement);
    }
}
