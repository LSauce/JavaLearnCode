package cn.kiroe.day14_enum._04ex;

/**
 * @author kiro
 * @description:
 * @data 11:42 28/10/2023
 **/
/*

**需求:**

一个支付场景, 假设某个APP只支持支付宝, 微信, 银联, ApplePay 这四种固定支付方式,
 需要记录用户使用的支付方式, 以便于统计用户支付习惯进行数据分析(用户画像)

我们可以使用枚举类型来描述这几种固定支付方式
 */


enum PayWay{
    // 常量对象， 向相当于 public static final PayWay ALIPAY = new PayWay(1,"ALIPAY","支付宝")
    ALIPAY(0,"ALIPAY","支付宝"), // 常量对象， 向相当于 public static final PayWay ALIPAY
    WECHAT(1,"WACHAT","微信"),
    UNIBANK(2,"UNIBANK","银联"),
    APPLEPAY(3, "APPLEPAY","苹果")
    ;
    private int id;
    private String name;
    private String label;

    PayWay(int id, String name, String label) {
        this.id = id;
        this.name = name;
        this.label = label;
    }

    public static PayWay findPayWayById(int id){
        PayWay payWay = PayWay.values()[id];

        return payWay;
    }


}

public class Demo {
    public static void main(String[] args) {
        // 假设前端 传值为 id=2
        int payTypeID = 2;
        // 统计用户 支付方式
        System.out.println("PayWay.findPayWayById(payTypeID) = " + PayWay.findPayWayById(payTypeID));
    }


    public static void count(PayWay payWay){
        switch (payWay){
            case ALIPAY:
                System.out.println("支付宝zf");
                break;
            case WECHAT:
                System.out.println("微信支付");
                break;
            case UNIBANK:
                System.out.println("银联支付");
                break;
            case APPLEPAY:
                System.out.println("苹果支付");
                break;
            default:
                System.out.println("没有支付");

        }
    }


}
