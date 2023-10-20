package cn.kiroe.day07.homework.bank;

/**
 * @author kiro
 * @description:
 * @data 20:56 19/10/2023
 **/
/*
编写一个类模拟银行账户（Account）的功能，包含的属性有"账户名（ID）"、"密码"、"账户余额"、"储蓄年利率"等。 其中：

账号名：要求每个账户的账户名都是唯一的，且按照固定格式自动生成：

第一位账户的账户名是"10001"

其后账户的账户名依次加1。比如第二位账户的账户名就是"10002"，第三位就是"10003".....

密码：新建账户时，可以选择自定义密码，也可以选择使用默认密码："000000"（6个0）

账户余额：可以选择在新建账户时预设一个值，也可以保持默认值0

储蓄年利率：由银行设置，和账户本身没有关系。你可以将它设置为"0.3%"（活期年利率一般都非常低，聊胜于无）

定义完属性后，再给出两个成员方法：

1，打印账户自身所有属性。2，根据传入的年限和储蓄年利率，计算本息合计后的余额。

注：计算利息时简单点，不考虑利滚利。即利息 = 利率 * 时间 * 本金
 */
public class BankMain {

    public static void main(String[] args) {
        Account account = new Account("123", "1000", "0.003");
        int year = 10;
        System.out.println(year+"年余额为"+ account.calcBalance(year));
        System.out.println("account.getBalance() = " + account.getBalance());
        System.out.println("account.toString() = " + account.toString());
    }
}
