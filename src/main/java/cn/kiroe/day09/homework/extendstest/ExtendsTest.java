package cn.kiroe.day09.homework.extendstest;

/**
 * @author kiro
 * @description:
 * @data 20:30 23/10/2023
 **/
/*
描述一下**方法覆盖/重写**的语法，从以下角度：

- 访问权限修饰符，可以更宽松，可以保持一致，但不能更加严格。

- **返回值类型（重点测试一下）**

  如果父类方法的返回值类型是一个父类类型，那么子类重写的方法可以返回子类类型。

  其余任何情况，都需要严格保持一致！（你测试的结果和这个一样吗？）

- 方法名

  必须保持一致！

- 形参列表

  必须保持一致！

测试过程中，可以使用注解`@Override`来检查方法重写的正确性。
 */
public class ExtendsTest {

}

class Father{


    // 测试返回类型 和 权限更宽松
    protected Object test2(){
        System.out.println("father test");
        return new Object();
    }
}
class Son extends Father{
    @Override
    public String test2() {
        System.out.println("test");
        return "test";
    }
}
