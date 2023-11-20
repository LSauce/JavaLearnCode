package cn.kiroe.day07.homework.bank;

import java.math.BigDecimal;

/**
 * @author kiro
 * @description:
 * @data 20:56 19/10/2023
 **/
public class Account {

    private int initId = 10001;
    // 账户名（ID）"、
    private int id;
    // "密码"、
    private String password = "000000";
    // "账户余额"、
    private BigDecimal balance;
    // "储蓄年利率
    private BigDecimal annualInterestRate;

    public BigDecimal calcBalance(int year) {

        return balance.multiply(new BigDecimal(year)).multiply(annualInterestRate).add(balance);
    }

    {
        this.id = initId++;
    }

    public Account(String password, String balance, String annualInterestRate) {
        this.password = password;
        this.balance = new BigDecimal(balance);
        this.annualInterestRate = new BigDecimal(annualInterestRate);
    }

    @Override
    public String toString() {
        return "Account{" +
                "initId=" + initId +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                '}';
    }

    public int getInitId() {
        return initId;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }
}
