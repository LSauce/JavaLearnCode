package cn.kiroe.day12.oop._01intern._02member._3ex;

/**
 * @author kiro
 * @description:
 * @data 11:20 26/10/2023
 **/
public class Demo {
}
class Outer {
    public int num = 10;
    class Inner {
        public int num = 20;
        public void show() {
            int num = 30;
            System.out.println(Outer.this.num);
            System.out.println(num);
            System.out.println(this.num);
        }
    }
}
