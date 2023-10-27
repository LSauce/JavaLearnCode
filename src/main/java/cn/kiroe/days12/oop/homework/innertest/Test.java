package cn.kiroe.days12.oop.homework.innertest;

/**
 * @author kiro
 * @description:
 * @data 20:12 26/10/2023
 **/
/*
用内部类来实现接口
 定义一个接口Compute，用来完成计算器的功能，比如最简单的加减乘除功能。
 请用以下两种方式测试：
   1，编写实现类进行测试
   2，用局部内部类进行测试
   3，使用匿名内部类进行测试
 */
public class Test {
    public static void main(String[] args) {
        IOperate addOperate = OperateFactory.getOperateByString("+");
        // 1，编写实现类进行测试
        System.out.println("new ComputeImpl().calc(10,20,operate) = " + new ComputeImpl().calc(10, 20, addOperate));
        //   2，用局部内部类进行测试
        class InnerCompute implements ICompute{

            @Override
            public double calc(double n1, double n2, IOperate operate) {
                return operate.operate(n1,n2);
            }
        }
        System.out.println("new InnerCompute().calc(20,10,operate) = " + new InnerCompute().calc(20, 10, addOperate));
        //   3，使用匿名内部类进行测试
        System.out.println(new ICompute() {

            @Override
            public double calc(double n1, double n2, IOperate operate) {
                return operate.operate(n1, n2);
            }
            {

            }
            int a = 20;
            public void tt(){

            }
        }.calc(50, 30, addOperate));

    }
}
//   1，编写实现类进行测试
class ComputeImpl implements  ICompute{


    @Override
    public double calc(double n1,double n2,IOperate operate) {
        return operate.operate(n1,n2);
    }
}

interface ICompute{

    public double calc(double n1,double n2,IOperate operate);

}

class OperateFactory{

    // 获取操作对象
    public static IOperate getOperateByString(String oper){
        switch (oper){
            case "+":
                return new AddOperateIpml();
            case "-":
                return new SubOperateIpml();
            case "*":
                return new MulOperateIpml();
            case "/":
                return new DivOperateIpml();
        }

        return null;
    }
}

// 简单工厂模式
interface IOperate{
     double operate(double num1,double num2);
}

// 创建 加减乘除 对应类
class AddOperateIpml implements IOperate{

    @Override
    public double operate(double num1, double num2) {
        return num1 + num2;
    }
}

class SubOperateIpml implements IOperate{

    @Override
    public double operate(double num1, double num2) {
        return num1 - num2;
    }
}
class MulOperateIpml implements IOperate{

    @Override
    public double operate(double num1, double num2) {
        return num1 * num2;
    }
}
class DivOperateIpml implements IOperate{

    @Override
    public double operate(double num1, double num2) {
        return num1 / num2;
    }
}
