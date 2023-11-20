package cn.kiroe.day10.oop._01polymorphic._03ex;

/**
 * @author kiro
 * @description:
 * @data 10:53 24/10/2023
 **/
public class Demo {
    public static void main(String[] args) {
        Father cf = new Son();
        System.out.println(cf.age);//48
        cf.teach();//论语
        //cf.playGame(); 不能打游戏，因为父类没这个成员
        Son c = (Son) cf;
        System.out.println(c.age);//28
        c.playGame();
    }
}

class Father{
    int age = 48;
    public void teach(){
        System.out.println("我要教Java");
    }
}
class Son extends Father{
    int age = 28;
    public void playGame(){
        System.out.println("孔子喜欢玩大乱斗！");
    }
    @Override
    public void teach() {
        System.out.println("我会教论语");
    }
}

