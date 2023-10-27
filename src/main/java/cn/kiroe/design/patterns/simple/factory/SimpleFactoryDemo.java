package cn.kiroe.design.patterns.simple.factory;

// 使用接口来规范操作，并方便添加
interface Operator {
    public Double operate(Double a, Double b);
}

/**
 * @author kiro
 * @description:
 * @data 16:23 21/10/2023
 **/
/*
简单工厂模式
    - 特点： 传入值，使用工厂来建立对象
    - 正式解释：
    - 使用工厂模式，可以将对象的创建与使用代码分离，
    -  提供一种统一的接口来创建不同类型的对象。
    -  在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，
    -  并且是通过使用一个共同的接口来指向新创建的对象。
 */
public class SimpleFactoryDemo {
    // 计算机的功能 计算两数a，b的 加减乘除
    // 未来可能添加其他操作
    public static void main(String[] args) {
        Operator operator = OperatorFactory.getOperatorInstance("-");
        // 因为使用 接受Double所以没 自动转换
        // 使用Integer 也不行，不会自动转换，因为为引用类型，且无父子关系
        System.out.println("operator.operate(2,3) = " + operator.operate(2.0, 1.0));
        exTest(new Integer(1),new Integer(1));
        exTest(1,2);

    }

    public static void exTest(double s1,double s2){

    }


}

//建立操作类
class Add implements Operator {
    @Override
    public Double operate(Double a, Double b) {
        return a + b;
    }
}

class Sub implements Operator {
    @Override
    public Double operate(Double a, Double b) {
        return a - b;
    }
}

class Mul implements Operator {

    @Override
    public Double operate(Double a, Double b) {
        return a * b;
    }
}

class Div implements Operator {

    @Override
    public Double operate(Double a, Double b) {
        return a / b;
    }
}

// 使用 简单工厂来 初始化对象
class OperatorFactory {

    //接受 字符串 返回对象
    public static Operator getOperatorInstance(String oper) {
        Operator operator = null;
        switch (oper) {
            case "+":
                operator = new Add();
                break;
            case "-":
                operator = new Sub();
                break;
            case "*":
                operator = new Mul();
                break;
            case "/":
                operator = new Div();
                break;

        }
        return operator;
    }
}

