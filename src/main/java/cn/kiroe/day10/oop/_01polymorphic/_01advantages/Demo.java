package cn.kiroe.day10.oop._01polymorphic._01advantages;

/**
 * @author kiro
 * @description:
 * @data 09:43 24/10/2023
 **/

/*

我们通过一个案例来理解多态的优缺点：

> 科学家要收集动物的叫声去研究，先要收集猫，狗两种动物的叫声研究。随后又扩展到其它动物，最后又需要研究人类。

我们可以先定义一个顶层父类Animal作为父类，然后定义具体动物类：猫和狗。

假如收集每种动物的叫声研究，都需要写一个方法，显然过于麻烦，程序扩展性也太差了。所以我们可以这么做：

1. 写一个方法来收集研究动物的叫声，方法的形参不写具体动物类，而写顶层祖先类：Animal。然后在方法体中，调用叫的方法即可。
2. 这样该方法在调用传参时，就可以Animal不同的子类对象了。这仍然是一个父类引用指向子类对象

这就是多态一个基本的使用案例，当传入方法不同的子类对象时，方法执行时就会根据不同的具体对象类型，来决定行为。
 */
public class Demo {

    public static void main(String[] args) {
        collectCatVoice(new Cat());
        collectCatVoice(new Dog());
    }
    // 多态:
    public static void collectCatVoice(Animal animal){
        animal.shout();
    }
}


class Animal{

    public void shout(){
        System.out.println("动物叫....");
    }


}

class Cat extends Animal{
    @Override
    public void shout() {
        System.out.println("猫叫");
    }
}

class Dog extends  Animal{
    @Override
    public void shout() {
        System.out.println("狗叫");
    }
}


