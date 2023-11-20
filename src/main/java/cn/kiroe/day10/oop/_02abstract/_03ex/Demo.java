package cn.kiroe.day10.oop._02abstract._03ex;

/**
 * @author kiro
 * @description:
 * @data 15:02 24/10/2023
 **/
/*
1. 抽象类编码练习

> 公司正在开发一套员工管理系统，需要对公司内部存在的员工进行管理
>
> 公司将员工分为三类，普通员工负责杂项工作，程序员负责技术开发，经理负责统筹规划
>
> 普通员工包含3个属性：姓名、工号以及工资，行为是工作
>
> 程序员包含3个属性：姓名、工号以及工资，行为是工作和加班（overtime work）
>
> 经理包含4个属性：姓名、工号、工资以及奖金（bonus），行为是工作

- 请使用所学的知识设计该员工系统
- 要求类中提供必要的方法进行属性访问（description）
 */
public class Demo {

    public static void main(String[] args) {
        // 父类引用
        BaseStaff staff = new Manager("fff",1000,1111);
        staff.printStaff();
        staff = new NormalStaff("张三",3000);
        staff.printStaff();
        staff = new Coder("李四",15000);
        staff.printStaff();
        if(staff instanceof  Coder){
            ((Coder)staff).overTimeWork();
        }
        staff.printStaff();



    }
}

abstract class BaseStaff{
    String name;
    int id;
    double salary;

    private static int initId = 10000;
    {
        initId++;
        this.id = initId;
    }

    public abstract void work();
    public  void printStaff(){
        System.out.println(this);
    }

    public BaseStaff(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "BaseStaff{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}

class Coder extends BaseStaff{
    @Override
    public void work() {
        System.out.println("coder工作");
    }
    public void overTimeWork(){
        System.out.println("加班");
    }
    public Coder(String name, double salary) {
        super(name, salary);
    }
}

class NormalStaff extends BaseStaff{

    @Override
    public void work() {
        System.out.println("normal加班");
    }

    public NormalStaff(String name, double salary) {
        super(name, salary);
    }
}

class  Manager extends BaseStaff{

    double bonus;
    @Override
    public void work() {
        System.out.println("管理公司");
    }

    public Manager(String name, double salary) {
        super(name, salary);
    }

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                "bonus=" + bonus +
                '}';
    }
}
