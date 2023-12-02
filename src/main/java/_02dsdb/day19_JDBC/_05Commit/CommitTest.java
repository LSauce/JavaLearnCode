package _02dsdb.day19_JDBC._05Commit;

import _02dsdb.day19_JDBC.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author Kiro
 * @Date 2023/11/30 11:48
 **/
public class CommitTest {
    /*

    事物测试
    开启事务
    提交事务
    情况不对，回滚事务
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        commitTest();
    }

    public static void commitTest() throws SQLException, ClassNotFoundException {
        // 开启事物
        // 转账代码
        //  来源，目标，金额
        boolean transfer = transfer("黄宗磊", "马骏翔", 1000000);

        if (transfer) {
            System.out.println("转账成功");
        } else {
            System.out.println("转账失败");
        }
    }

    /**
     * @param sourceName    资金来源
     * @param targetName    资金目标
     * @param transferMoney 转账钱数
     * @return
     */
    public static boolean transfer(String sourceName, String targetName, int transferMoney) throws SQLException, ClassNotFoundException {

        // 1. 获取链接
        Connection connection = JDBCUtil.getConnection();
        // 开启事物
        connection.setAutoCommit(false);
        try {
            // 2. 执行sql，扣钱和 加钱，最好查询 是否有余额
            PreparedStatement preparedStatement = connection.prepareStatement("select money from account where name = ?");
            preparedStatement.setString(1, sourceName);
            ResultSet resultSet = preparedStatement.executeQuery();
            int sourceBalance = -1;
            if (resultSet.next()) {
                sourceBalance = resultSet.getInt(1);
            }
            if (sourceBalance < transferMoney) {
                return false;
            }
            // 钱够了
            // 准备扣钱
            PreparedStatement reducePreparedStatement = connection.prepareStatement("update account set money = money - ? where name = ? AND money > ?");
            reducePreparedStatement.setInt(1, transferMoney);
            reducePreparedStatement.setString(2, sourceName);
            reducePreparedStatement.setInt(3, transferMoney);
            // 准备加钱
            PreparedStatement addPreparedStatement = connection.prepareStatement("update account set money = money + ? where name = ?");
            addPreparedStatement.setInt(1, transferMoney);
            addPreparedStatement.setString(2, targetName);
            // 执行
            int reduceResult = reducePreparedStatement.executeUpdate();
            if(reduceResult != 1){
                System.out.println("无法扣钱");
                return false;
            }
            int addResult  =  addPreparedStatement.executeUpdate();
            if(addResult != 1){
                System.out.println("收款方不存在，或者无法加钱");
                return false;
            }
            // 提交事物
            connection.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            return false;
        }
    }


}
