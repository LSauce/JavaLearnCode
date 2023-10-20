package cn.kiroe.day08.homework;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author kiro
 * @description:
 * @data 20:15 20/10/2023
 **/
/*
定义一个银行账户类Account, 3个属性, 用户名, 密码, 余额.

使用Getter/Setter方法实现以下功能:

要求用户名长度4-6位

密码长度6位

余额大于100

class Account{
private String userName;
private String password;
private double balance;
}



注:实际开发中几乎不会修改G/S方法实现对成员变量赋值的控制,这道题仅做语法练习,不用多想。
 */
public class BankEX {

    @Test
    public void AccountTest(){
        Account account = new Account("kiroecn", "123456", "101000.1");
        System.out.println("account = " + account);
        Account account2 = new Account("kiroecn2", "1234562", "10.10001");
        System.out.println("account = " + account2);
    }
}

//定义一个银行账户类Account, 3个属性, 用户名, 密码, 余额.
class Account {
    private String userName;
    private String password;
    private BigDecimal balance;


    public Account(String username, String password, String blance) {
        setUserName(username);
        setPassword(password);
        setBalance(blance);
    }

    public String getUserName() {
        return userName;
    }

    //username  要求用户名长度4-6位
    public void setUserName(String userName) {
        if (userName.length() >= 4 && userName.length() <= 6) {
            this.userName = userName;
        }
    }

    public String getPassword() {
        return password;
    }
    // 密码长度6位

    public void setPassword(String password) {
        if (password.length() == 6) {
            this.password = password;
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }
    // 余额大于100
    public void setBalance(String balance) {
        BigDecimal decimal = new BigDecimal(balance);
        if (decimal.compareTo(new BigDecimal(100)) > 0) {
            this.balance = decimal;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
