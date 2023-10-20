package cn.kiroe.day08._04extends._5advantage;

/**
 * @author kiro
 * @description:
 * @data 16:37 20/10/2023
 **/
/*
这里给出一个继承语法的练习案例，通过案例我们来分析一下继承的优缺点：

> 练习：
>
> 在一款游戏中，我们设计了三种类型的鸭子，这些鸭子有一些共同的属性，也有共同的行为，比如都可以叫，都会游泳等。
>
> 编写程序，描述这些鸭子。
>
> 后来，需求更改了，这些鸭子不能游泳了，但是都会飞，怎么改呢？
>
> 再后来，需求又改了，新增了一种鸭子，但这个鸭子不会飞，又怎么办呢？
 *//*

优点：
1. 代码复用
2. 方便更改代码，提示维护性
缺点：
1. 父类中 所有都继承
    解决： 可重写父类方法

    */
public class Demo {

    public static void main(String[] args) {
        FourthDuck fourthDuck = new FourthDuck();
        System.out.println("fourthDuck.name = " + fourthDuck.name);
        fourthDuck.fly();
    }
}
class Duck{
    String name;
    public void shout(){

    }

   /* public void swim(){

    }*/
    public void fly(){

    }
}
class FirstDuck extends Duck{

}
class SecondDeck extends Duck{

}

class ThirdDuck extends Duck{

}


class FourthDuck extends Duck{
    @Override
    public void fly(){
        System.out.println("not fly ..");
    }

}