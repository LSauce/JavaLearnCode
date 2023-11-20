package cn.kiroe.day11.oop07._02override;

/**
 * @author kiro
 * @description:
 * @data 09:55 26/10/2023
 **/

/*

### 方法重写中的返回值类型问题

父子类方法重写中，方法声明中返回值类型的书写。

1. **基本类型和void：**必须保持一模一样，不存在类型提升。
2. **引用类型：**不必保持一模一样，存在自动向上转型。
   1. 普通类：父类中的方法返回一个普通类类型
      - 子类方法中可以返回该类型
      - 也可以返回该类的子类类型
   2. 抽象类：父类中的方法返回一个抽象类类型
      - 子类方法可以返回该类型
      - 也可以返回抽象类的实现类类型
   3. 接口：父类中的方法返回一个接口类型
      - 子类方法可以返回该类型
      - 也可以返回接口的实现类类型

3. 总结： 重写中 基本数据类型和void： 在方法的返回中无 类型的提升
          引用数据类型： 可改为子类，能自动类型转化
 */
public class Demo {
}

class Father{
    public A m1(){
        return new A();
    }

    public AbstractA m3(){
        return new AAA();
    }

    public IAA m4(){
        return null;
    }
}

class Son extends Father{
    @Override
    public AA m1() {
        return new AA();
    }

    @Override // 可以是 子类类型
    public AAA m3() {
        return null;
    }

    @Override
    public IAAImpl m4() {
        return null;
    }
}

class A{

}
class AA extends A{

}


abstract class AbstractA{

}
class AAA extends AbstractA{

}

interface IAA{

}

class IAAImpl implements IAA{

}