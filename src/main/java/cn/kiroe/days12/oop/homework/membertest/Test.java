package cn.kiroe.days12.oop.homework.membertest;

/**
 * @author kiro
 * @description:
 * @data 20:03 26/10/2023
 **/

/*

成员内部类，静态内部类的区别实际上时非常明显的，对象的创建和使用都有很大差异。请完成下列题目：

根据注释填写（1），（2），（3）处的代码：

public class Test{
public static void main(String[] args){
     //(1)创建并初始化Bean1类对象bean1
     bean1.i++;
     //(2)创建并初始化Bean2类对象bean2
     bean2.j++;
     //(3)创建并初始化Bean3类对象bean3
     bean3.k++;
}
class Bean1{
     public int i = 0;
}
static class Bean2{
     public int j = 0;
}
}
class Bean{
class Bean3{
     public int k = 0;
}
}
请根据注释,分别对应创建对象的语句
 */
public class Test {

    public static void main(String[] args) {
        //(1)创建并初始化Bean1类对象bean1
        Bean1 bean1 = new Test().new Bean1(); // 对于在普通类中,在静态方法中，需有外部类对象
        bean1.i++;
        //(2)创建并初始化Bean2类对象bean2,  Bean2为 静态内部类，不需要外部对象，直接new
        Bean2 bean2 = new Bean2();// 使用Test.Bean2() 指定类型,在外部类中 直接 Bean2()
        bean2.j++;
        //(3)创建并初始化Bean3类对象bean3， // 其他类 调用 外部类中普通内部类，需要 外部类对象
        Bean.Bean3 bean3 = new Bean().new Bean3();// 使用Bean.Bean3 指定类型
        bean3.k++;
    }

    static class Bean2 {
        public int j = 0;
    }

    class Bean1 {
        public int i = 0;
    }
}

class Bean {
    class Bean3 {
        public int k = 0;
    }
}
