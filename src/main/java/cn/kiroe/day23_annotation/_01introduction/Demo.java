package cn.kiroe.day23_annotation._01introduction;

/**
 * @author kiro
 * @description:
 * @data 11:13 8/11/2023
 **/
// 注解可 限制要求
@Deprecated
public class Demo {
    @Deprecated
    int a =1;

    public static void main(@Deprecated String[] args) {
        func();
    }
    @Deprecated // 说明该方法是 过期的
    public static void func(){

    }
}

class Father{

    public void m1(){

    }
}

class Son extends Father{
    @Override
    public void m1() {
        super.m1();
    }
    public void m2(){

    }
}
