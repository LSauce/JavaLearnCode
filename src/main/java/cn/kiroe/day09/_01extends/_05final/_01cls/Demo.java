package cn.kiroe.day09._01extends._05final._01cls;

/**
 * @author kiro
 * @description:
 * @data 16:10 23/10/2023
 **/

/*
final
    - 修饰类时，表示最后的类，最终的类，不能被继承
    - 修饰方法, 表示最终的方法,不能被重写


 */
public class Demo {

}

class Father{
    public final void m1(){

    }

    //private 方法 可通过编译，但冗余了，不建议，private本身就不能重写
    private final void m2(){

    }
    // 'static' method declared 'final'
    // static final 冗余的，static本身就不能重写
    public static final void m3(){}
    // Modifier 'final' not allowed here ,构造器不能使用 final,无法通过编译
    //public final Father() {}
}

class Son extends Father{
    /*@Override // overridden method is final
    public final void m1(){
    }*/
}
/*
final 表示该类无法被继承了

不能被继承的类：
    String
 */
final  class A{

}
// Cannot inherit from final 'day09._01extends._05final._01cls.A'
// class B extends A{}

// Cannot inherit from final 'java.lang.String'
// class C extends String{ }
