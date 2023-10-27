package cn.kiroe.day10.oop._03interface._06ex;

/**
 * @author kiro
 * @description:
 * @data 16:50 24/10/2023
 **/
/*
1. 教练（Coach）和运动员（Sportsman）案例

> 小试牛刀请用所学知识分析：这个案例中有哪些抽象类，哪些接口，哪些具体类。

现在有乒乓球运动员和篮球运动员，乒乓球教练和篮球教练。为了能够出国交流，跟乒乓球相关的人员都需要学习英语。
 */
public class Demo {


}
// 抽象教练类

abstract class AbstractCoach{
    String name;
    int age;
    double salary;

    //抽象方法
    abstract void teach();
}
// 具体的教练类
class PingPangCoach extends AbstractCoach{

    @Override
    void teach() {
        System.out.println("教学篮球");
    }
}

// 运动员类：
abstract class AbstractSportsman{
    String name;
    String age;
    //比赛
     abstract void play();
}
// 具体的运动员类
class PingPangPlayer extends AbstractSportsman{


    @Override
    void play() {
        System.out.println("pingpang");
    }
}

class BasketballPlayer extends AbstractSportsman{


    @Override
    void play() {
        System.out.println("basketball");
    }
}


//学英语
interface ILearnEnglish{
    void LearnEnglish();
}




