package cn.kiroe.day06.oop1.homework.object.exercise;

import cn.kiroe.day03.method._06unittest.Student;

/**
 * @author kiro
 * @description:
 * @data 14:16 18/10/2023
 **/
public class MarketTest {

    public static void main(String[] args) {
        /*
        1. "手机类的Samsung Galaxy S21 8000元"
        2. "家具类的海尔冰箱 3000元"
        3. "日用品类的海飞丝洗发水 30元"

         */

        Item phone = new Item("Galaxy S21",8000,"手机");
        Item refrigerator = new Item("海尔冰箱",3000,"家具");
        Item shampoo = new Item("海飞丝洗发水",3000,"日用品");
        System.out.println(phone.sell(1000));
        System.out.println(refrigerator.sell(10000));
        System.out.println(shampoo.sell(4000));

    }
}

/*

设计物品（Item）类

它具有以下属性：

1. 名字
2. 价格
3. 类别
 */

class Item {
    String name;
    double price;
    String category;

    public Item(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // 1. 售卖。该方法需要传入一个参数表示购买使用的金钱，
    // 如果金钱足够则打印"xx物品被卖出"的信息，并将找零作为返回值。
    // 否则打印"金钱不足，购买失败"，并将"-1"作为返回值表示购买失败。
    public double sell(int money) {
        double result = -1;
        if (money >= this.price) {
            System.out.println(this.name + " 物品被卖出");
            result = money - this.price;
        }else {
            System.out.println("金钱不足，购买失败");
        }

        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
