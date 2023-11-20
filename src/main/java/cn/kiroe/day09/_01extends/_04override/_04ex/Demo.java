package cn.kiroe.day09._01extends._04override._04ex;

/**
 * @author kiro
 * @description:
 * @data 15:58 23/10/2023
 **/

/*

当对象为子类是 ，父类中调用 重写的 方法，此时 子类 并没有进行显式赋值，值可能都为 默认初始化值
 */
public class Demo {
    public static void main(String[] args) {
        //Son s = new Son();
        //Son s2 = new Son(300);
       //Father fs = new Son();
        Father f = new Father();
    }
}

class Father {
    int num = 100;

    public int getNum() {
        return num;
    }

    public Father() {
        // 该行在执行时,如果创建的是子类对象,
        // 那么子类的任何赋值手段都没有执行,那子类中的num一定是0
        System.out.println(getNum());
    }

}

class Son extends Father {
    int num = 200;

    @Override
    public int getNum() {
        return num;
    }

    public Son() {
        super();
    }

    public Son(int num) {
        this.num = num;
    }
}