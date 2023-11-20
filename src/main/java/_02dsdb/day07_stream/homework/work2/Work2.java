package _02dsdb.day07_stream.homework.work2;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author kiro
 * @description:
 * @data 20:11 16/11/2023
 **/
/*
2, 基于提供的三个参考类型: 实现

 */
public class Work2 {
    public static void main(String[] args) {
        List<Transaction> transactions = TransactionRecord.transactions;
        // 找出2011年发生的交易记录, 按照从低到高交易额排序
        List<Transaction> findByYearList = findRecordByYear(transactions);
        System.out.println("findByYearList = " + findByYearList);
        // 找出交易员都在哪些不同的城市工作过的城市
        Set<String> citySet = findCity(transactions);
        System.out.println("citySet = " + citySet);
        // 查找来自北京的交易, 按交易员姓名排序
        List<Transaction> findByCityList = findRecordByCity(transactions);
        System.out.println("findByCityList = " + findByCityList);
        // 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
        String allTraderName = getAllTraderName(transactions);
        System.out.println("allTraderName = " + allTraderName);
        // 判断有没有交易员在北京工作
        boolean hasWorkingInBeijing = hasWorkingInBeijing(transactions);
        System.out.println("hasWorkingInBeijing = " + hasWorkingInBeijing);
        // 打印所有发生在北京的交易记录金额
        List<Integer> allMoneyInBeijing = getAllMoneyInBeijing(transactions);
        System.out.println("allMoneyInBeijing = " + allMoneyInBeijing);
        // 所有交易中最高的交易是多少
        int maxValue = getMaxValue(transactions);
        System.out.println("maxValue = " + maxValue);
        // 所有交易中, 交易最低的交易信息
        Transaction minValueTransaction = getMinValueTransaction(transactions);
        System.out.println("minValueTransaction = " + minValueTransaction);

    }


    // 2, 基于提供的三个参考类型: 实现
    // 找出2011年发生的交易记录, 按照从低到高交易额排序
    public static List<Transaction> findRecordByYear(List<Transaction> transactions) {
        List<Transaction> collected = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((t1, t2) -> t1.getValue() - t2.getValue())
                .collect(Collectors.toList());
        return collected;
    }


    // 找出交易员都在哪些不同的城市工作过的城市
    public static Set<String> findCity(List<Transaction> transactions) {

        Set<String> citySet = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet());
        return citySet;
    }

    // 查找来自北京的交易, 按交易员姓名排序
    private static List<Transaction> findRecordByCity(List<Transaction> transactions) {
        List<Transaction> collected = transactions.stream()
                .filter(t -> "beijing".equals(t.getTrader().getCity()))
                .sorted((t1, t2) -> t1.getTrader().getName().compareTo(t2.getTrader().getName()))
                .collect(Collectors.toList());

        return collected;
    }

    // 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
    private static String getAllTraderName(List<Transaction> transactions) {
        Optional<String> reduce = transactions.stream().map(t -> t.getTrader().getName()).sorted((n1, n2) -> n1.compareTo(n2)).reduce((n1, n2) -> n1 + " " + n2);
        return reduce.orElseGet(null);
    }

    // 判断有没有交易员在北京工作
    private static boolean hasWorkingInBeijing(List<Transaction> transactions) {
        return transactions.stream().anyMatch(t -> "beijing".equals(t.getTrader().getCity()));
    }

    // 打印所有发生在北京的交易记录金额
    private static List<Integer> getAllMoneyInBeijing(List<Transaction> transactions) {
        List<Integer> collect = transactions.stream().filter(t -> "beijing".equals(t.getTrader().getCity())).map(t -> t.getValue()).collect(Collectors.toList());
        return collect;
    }

    // 所有交易中最高的交易是多少
    private static int getMaxValue(List<Transaction> transactions) {
        Optional<Integer> reduce = transactions.stream().map(Transaction::getValue).reduce(Math::max);
        return reduce.orElse(-1);
    }

    // 所有交易中, 交易最低的交易信息
    private static Transaction getMinValueTransaction(List<Transaction> transactions) {
        Transaction transaction = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2).orElse(null);
        return transaction;
    }


}


