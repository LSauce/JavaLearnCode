package cn.kiroe.day10.oop._01polymorphic._02cast;

/**
 * @author kiro
 * @description:
 * @data 10:05 24/10/2023
 **/

/*

泛型缺点：  当强制类型转换时可能会出错

**发生的前提:**

-  必须将父类引用转换成它的子类引用，如果不是转换成它的子类引用，会编译报错。

**成功的前提:**

- 强转后的引用类型必须能够真正的指向该对象, 即强转后的引用的类型必须是该对象的类型或者其父类型


可以使用instanceof 关键字
// true表示该引用指向的对象，是后面类名的一个对象或者子类对象。
// false 反之不是,null 返回的也为 false
 */
public class Demo {
    public static void main(String[] args) {

        GrandFather gf = new Son();

        Father father = (Father) gf;
        Son son = (Son)father;
        if(son instanceof GrandSon) {
            GrandSon grandSon = (GrandSon) son;
        }else {
            System.out.println("转化失败");
        }

        System.out.println(gf instanceof Son);
        System.out.println(father instanceof Son);
        System.out.println(son instanceof Son);
        System.out.println(gf instanceof GrandSon);
    }
}

class GrandFather {

}

class Father extends GrandFather {

}

class Son extends Father {

}

class GrandSon extends Son {

}
