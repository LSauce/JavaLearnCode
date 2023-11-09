package cn.kiroe.day23_annotation._03use;

/**
 * @author kiro
 * @description:
 * @data 11:34 8/11/2023
 **/
/*
- 每个属性都要赋值

- 可以不赋值,但是要有默认值, default
- 数组形式赋值 {}
- 如果只有1个属性, 名字叫value, 可以简化赋值
- 如果属性类型是引用类型, 不能是null
 */
public class Demo {

    public static void main(String[] args) {

    }

    @MyAnno1(attribute1 = "test",attribute2 = 123)
    public static void func(){

    }

    @MyAnno3(attributes = {"zs","ls","ww"})
    @MyAnno2()
    public static void func2(){

    }
}

@interface MyAnno1{
    String attribute1();
    int attribute2();

}

@interface MyAnno2{

    String attribute() default "";
}

@interface MyAnno3{

    String[] attributes();
}

@interface MyAnno4{
    // 可以简化赋值
    String value();

    Class f();
}
