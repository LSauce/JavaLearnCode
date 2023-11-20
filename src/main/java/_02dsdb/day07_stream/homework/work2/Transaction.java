package _02dsdb.day07_stream.homework.work2;

// 交易
public class Transaction {

    private Trader trader;// 交易员
    private int year;// 交易年份
    private int value;//交易年份

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }
    public void setTrader(Trader trader) {
        this.trader = trader;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
