package _02dsdb.day07_stream.homework.work2;

import java.util.Arrays;
import java.util.List;

// 交易记录
public class TransactionRecord {

    public static List<Transaction> transactions;

    static {
        Trader trader1 = new Trader("zs", "beijing");
        Trader trader2 = new Trader("ls", "beijing");
        Trader trader3 = new Trader("wu", "shanghai");
        Trader trader4 = new Trader("zl", "shanghai");

        transactions = Arrays.asList(
                new Transaction(trader4, 2011, 300),
                new Transaction(trader1, 2012, 1000),
                new Transaction(trader1, 2011, 400),
                new Transaction(trader2, 2012, 710),
                new Transaction(trader2, 2012, 700),
                new Transaction(trader3, 2012, 950)
        );
    }

}
