package _02dsdb.day02_collection.homework.collectionwork;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
2，有一批订单信息，订单信息包括 下单人，下单金额，下单时间

1.现在想找出最大的下单金额对应的下单人

2.想找出2022-2023年下单的所有订单信息

3.删除低于平均下单金额的账单
 */
public class Work1 {

    private static ArrayList<Order> list = new ArrayList<>();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static void initOrderInfo() throws ParseException {

        list.add(new Order(new Purchaser("zs", 53), new BigDecimal(1), dateFormat.parse("2020-01-12")));
        list.add(new Order(new Purchaser("zs1", 13), new BigDecimal(2), dateFormat.parse("2021-01-12")));
        list.add(new Order(new Purchaser("zs2", 23), new BigDecimal(3), dateFormat.parse("2022-01-12")));
        list.add(new Order(new Purchaser("zs3", 33), new BigDecimal(4), dateFormat.parse("2023-01-12")));
        list.add(new Order(new Purchaser("zs4", 43), new BigDecimal(5), dateFormat.parse("2022-01-12")));
        list.add(new Order(new Purchaser("zs5", 12), new BigDecimal(6), dateFormat.parse("2023-01-12")));
        list.add(new Order(new Purchaser("zs6", 52), new BigDecimal(7), dateFormat.parse("2024-01-12")));
        list.add(new Order(new Purchaser("zs7", 51), new BigDecimal(8), dateFormat.parse("2021-01-12")));
    }

    public static void main(String[] args) throws ParseException {
        // 初始化 订单信息
        initOrderInfo();
        // 1.现在想找出最大的下单金额对应的下单人

        Order orderMaxAmount = getOrderMaxAmount();
        System.out.println(orderMaxAmount);

        //2.想找出2022-2023年下单的所有订单信息
        ArrayList<Order> orders = new ArrayList<>();
        String startData = "2022-01-01";
        String endData = "2023-01-01";
        findInfoByDate(startData, endData, orders);
        System.out.println("orders = " + orders);
        //3.删除低于平均下单金额的账单
        System.out.println("算出平均金额");
        // 算出平均金额
        BigDecimal average = getAverage();
        System.out.println(average);
        delLower(average);
        System.out.println("list = " + list);
    }

    private static void delLower(BigDecimal average) {
        ArrayList<Order> removeList = new ArrayList<>();
        for (int i = 0 ; i < list.size();i++) {
            Order order = list.get(i);
            if(average.compareTo(order.getAmount()) > 0){
                removeList.add(order);
            }
        }
        list.retainAll(removeList);
    }

    private static BigDecimal getAverage() {
        BigDecimal sum = new BigDecimal(0);
        for (Order order : list) {
           sum =  sum.add(order.getAmount());
        }

        BigDecimal average =  sum.divide(BigDecimal.valueOf(list.size()));
        return average;
    }

    private static void findInfoByDate(String startData, String endData, ArrayList<Order> orders) throws ParseException {
        for (Order order : list) {
            if (order.getTime().compareTo(dateFormat.parse(startData)) >= 0
                    && order.getTime().compareTo(dateFormat.parse(endData)) < 0
            ) {

                orders.add(order);
            }
        }
    }

    private static Order getOrderMaxAmount() {
        Order orderMaxAmount = null;
        BigDecimal maxAmount = new BigDecimal(0);
        for (Order order : list) {
            if (order != null && order.getAmount().compareTo(maxAmount) > 0) {
                maxAmount = order.getAmount();
                orderMaxAmount = order;
            }
        }
        return orderMaxAmount;
    }
}

class Order {
    // 单人，下单金额，下单时间
    // Orderer, order amount, order time
    private Purchaser purchaser;
    private BigDecimal amount;
    private Date time;

    public Order(Purchaser purchaser, BigDecimal amount, Date time) {
        this.purchaser = purchaser;
        this.amount = amount;
        this.time = time;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getTime() {
        return time;
    }

    public Purchaser getPurchaser() {
        return purchaser;
    }

    @Override
    public String toString() {
        return "Order{" +
                "purchaser=" + purchaser +
                ", amount=" + amount +
                ", time=" + time +
                '}';
    }
}


class Purchaser {
    private String name;
    private int age;

    public Purchaser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Purchaser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
