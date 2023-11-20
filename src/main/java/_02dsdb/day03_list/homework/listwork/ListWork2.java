package _02dsdb.day03_list.homework.listwork;

import java.util.*;

enum BallType {
    RedBall("红球"), BlueBall("蓝球");
    final String name;

    BallType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BallType{" +
                ", name='" + name + '\'' +
                '}';
    }
}

/**
 * @author kiro
 * @description:
 * @data 14:08 11/11/2023
 **/
/*
请存储到List中一注随机生成双色球号码。
 双色球规则：
 双色球每注投注号码由 6个红色球号码 和 1个蓝色球 号码组成。
  红色球号码从1—33中选择(红色号码不重复)；蓝色球号码从1—16中选择；
 */
public class ListWork2 {
    public static void main(String[] args) {
        System.out.println("Integer.sum(1,2) = " + Integer.sum(1, 2));
        // 获取 双色球
        List<Ball> ballList = BallFactory.getBallList();
        System.out.println("ballList = " + ballList);
        Arrays.copyOf(new boolean[2],1);
    }


}

class BallFactory {
    public static List<Ball> getBallList() {
        // 红色球号码从1—33中选择(红色号码不重复)
        // 随机出 6个不重复的数
        int count = 6;
        int maxNumber = 33;
        int minNumber = 1;
        Random random = new Random();
        ArrayList<Ball> balls = new ArrayList<>();
        while (balls.size() != count) {
            Ball newBall = getRandomBall(maxNumber, minNumber, BallType.RedBall);
            if (!balls.contains(newBall)) {
                balls.add(newBall);
            }
        }
        balls.add(getRandomBall(16, 1, BallType.BlueBall));
        return balls;
    }

    private static Ball getRandomBall(int maxNumber, int minNumber, BallType ballType) {
        int random = (int) (Math.random() * (maxNumber - minNumber+1) + minNumber);
        Ball newBall = new Ball(random, ballType);
        return newBall;
    }
}

class Ball {
    int number;
    BallType ballType;

    public Ball(int number, BallType ballType) {
        this.number = number;
        this.ballType = ballType;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "number=" + number +
                ", ballType=" + ballType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (number != ball.number) return false;
        return ballType == ball.ballType;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (ballType != null ? ballType.hashCode() : 0);
        return result;
    }
}
