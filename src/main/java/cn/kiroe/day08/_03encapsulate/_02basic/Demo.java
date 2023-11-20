package cn.kiroe.day08._03encapsulate._02basic;

/**
 * @author kiro
 * @description:
 * @data 15:24 20/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
        Employer employer = new Employer();
        employer.setName("test");
        employer.setAge(1000);
        employer.setSalary(5000);
        System.out.println("employer = " + employer);
        //通过 有参构造

    }

}

class Employer{
    public String name;
    private int age;
    private double salary;

    public Employer() {
    }

    public Employer(String name, int age, double salary) {
        this.name = name;
        setAge(age);
        setSalary(salary);// 构造方法中 调用set方法
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if(age > 0  && age < 101) {
            this.age = age;
        }
    }

    public void setSalary(double salary) {
        if( salary >= 10000 && salary <= 15000){
            this.salary = salary;
        }

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
