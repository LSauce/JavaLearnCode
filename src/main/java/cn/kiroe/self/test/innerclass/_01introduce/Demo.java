package cn.kiroe.self.test.innerclass._01introduce;

/**
 * @author kiro
 * @description:
 * @data 21:04 24/10/2023
 **/
/*
## 定义与分类

**基本概念:**

在Java语言中类可以嵌套定义，广义的内部类指的是定义在另一类当中的一个类。



**分类:**

根据内部类在类中定义的位置不同:

- **成员位置**
  - 成员内部类
  - 静态内部类
- **局部位置**
  - 局部内部类
  - 匿名内部类
  - Lambda表达式s
 */
public class Demo {
    //成员内部类位置
    public static void main(String[] args) {
        Computer computer = new Computer();
        Computer.CPU cpu = computer.new CPU();// 需要通过 外部类对象来 创建内部类对象

        computer.innerClassTest1();
    }


}

class Computer{

    private int a =10;
    //- **成员位置**
    //  - 成员内部类
    class CPU{
        private void test(){
            System.out.println("cpu innerClass hello");
            a = 100;
            System.out.println(a);
        }
    }

    public void innerClassTest1(){
        new CPU().test(); // 可无视 private权限
    }
    //  - 静态内部类
    //- **局部位置**
    //  - 局部内部类
    //  - 匿名内部类
    //  - Lambda表达式s
}


