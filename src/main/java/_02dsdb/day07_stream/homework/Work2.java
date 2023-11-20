package _02dsdb.day07_stream.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum Province {
    JX(1, "江西"), BJ(1, "北京"), WH(2, "武汉"), SH(3, "上海");
    int id;
    String info;

    Province(int id, String info) {
        this.id = id;
        this.info = info;
    }
}

/**
 * @author kiro
 * @description:
 * @data 19:43 16/11/2023
 **/
/*
2, 基于提供的三个参考类型: 实现
// 找出2011年发生的交易记录, 按照从低到高交易额排序
// 找出交易员都在哪些不同的城市工作过的城市
// 查找来自北京的交易, 按交易员姓名排序
// 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
// 判断有没有交易员在北京工作
// 打印所有发生在北京的交易记录金额
// 所有交易中最高的交易是多少
// 所有交易中, 交易最低的交易信息
 */
public class Work2 {

    public static List<TransactionRecord> initInfo() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<TransactionRecord> transactionRecords = new ArrayList<>();
        Trader trader1 = new Trader("zdx");
        Trader trader2 = new Trader("hj");
        Trader trader3 = new Trader("dzr");
        Trader trader4 = new Trader("ljh");

        transactionRecords.add(new TransactionRecord("买会员", 1000, sdf.parse("2023-12-1"), trader1, Province.WH));
        return null;
    }


    public static void main(String[] args) {

    }
}

class TransactionRecord {
    private static int initId = 100001;
    // 包括字段 交易id、交易内容、交易金额、 交易时间、交易员、交易省份
    int id;
    String content;
    double money;
    Date date;
    Trader trader;
    Province province;

    public TransactionRecord(String content, double money, Date date, Trader trader, Province province) {
        this.content = content;
        this.money = money;
        this.date = date;
        this.trader = trader;
        this.province = province;
    }

    @Override
    public String toString() {
        return "TransactionRecord{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", money=" + money +
                ", date=" + date +
                ", trader=" + trader +
                ", province=" + province +
                '}';
    }
}

class Trader {
    private static int initId = 10001;
    int id;
    // 包括字段 姓名
    String name;

    public Trader(String name) {
        this.id = initId++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                '}';
    }
}
