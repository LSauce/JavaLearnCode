package cn.kiroe.day07.homework.question6;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author kiro
 * @description:
 * @data 22:02 19/10/2023
 **/
/*

设计一个员工类(Staff)，要求该类：
     属性: 姓名,性别,工号,工资
     构造器:
     姓名的单参构造器、姓名和性别的双参构造器、姓名、性别和工资的三参构造器
其中员工的工号要求(每一位员工都必须有工号):
     第一个员工对象的工号是10001
     第二个员工对象的工号是10002
     第三个员工对象的工号是10003
     ....
现在每位员工都要缴纳一个固定额的公积金（比如2000），要求在员工类中设计一个方法求员工的到手工资。（除了扣除这个固定额度的公积金，不考虑诸如扣税等其余问题）
最后再定义一个方法用于打印员工对象的各种属性取值，其中在打印工资时，要打印实际到手工资。
将该类定义完毕后，尝试创建对象，测试一下代码。
 */
public class Question6 {
    @Test
    public void StaffTest(){
        /*
        现在每位员工都要缴纳一个固定额的公积金（比如2000），要求在员工类中设计一个方法求员工的到手工资。
        （除了扣除这个固定额度的公积金，不考虑诸如扣税等其余问题）
        最后再定义一个方法用于打印员工对象的各种属性取值，其中在打印工资时，要打印实际到手工资。
        将该类定义完毕后，尝试创建对象，测试一下代码。
         */
        ArrayList<Staff> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Staff staff = new Staff("张"+i,"未知",(Integer.parseInt("10") - i)*1000 + "");
            System.out.println("staff = " + staff);
        }


    }
}

class Staff{
 //属性: 姓名,性别,工号,工资
     String name;
     String gender;
     private int id;
     BigDecimal wages = new BigDecimal(0);

     private static int initId = 10001;

 /*      构造器:
    姓名的单参构造器、姓名和性别的双参构造器、姓名、性别和工资的三参构造器
    其中员工的工号要求(每一位员工都必须有工号):
    第一个员工对象的工号是10001
     第二个员工对象的工号是10002
    第三个员工对象的工号是10003*/
    {
        this.id = initId;
        initId++;
    }
    public Staff(String name) {
        this.name = name;
    }

    public Staff(String name, String sex) {
        this.name = name;
        this.gender = sex;
    }

    public Staff(String name, String gender, String wages) {
        this.name = name;
        this.gender = gender;
        this.wages = new BigDecimal(wages);
    }

    public BigDecimal getFinalWages(String accumulationFund){
        BigDecimal af = new BigDecimal(accumulationFund);
        if(wages.compareTo(af) > 0){
            return wages.subtract(af);
        }
        return new BigDecimal(0);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", wages=" + getFinalWages("2000") +
                '}';
    }
}
