package cn.kiroe.day07.oop2._01game._02static._01.introduce;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author kiro
 * @description:
 * @data 11:27 19/10/2023
 **/
/*
没有静态局部变量
 */
public class Demo {
    public static void main(String[] args) {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Player p3 = new Player("p3");

        Team team = new Team("t1");
        team.addPlayer(p1);
        team.addPlayer(p2);
        team.addPlayer(p3);

        team.obtainingPoints(p1,3);
        team.obtainingPoints(p2,2);
        team.obtainingPoints(p3,1);
        System.out.println(team.name + " 团队总得分为："+team.totalScore);

    }
}

class Player{
    String name;
    int scoreCount;//球员得分
    private static int initId = 1001; // id记录
    private int id;

    public int getId() {
        return id;
    }



    public Player(String name) {
        this.id = Player.initId;
        this.name = name;
        Player.initId++;

    }

    public int shot(int getScore){
        this.scoreCount += getScore;
        System.out.println("编号"+this.id+" "+this.name +"得分："+ getScore+", 总得分："+ this.scoreCount);
        return this.scoreCount;
    }

}

class Team{
    String name;

    HashSet<Player> members;
    int totalScore;



    public Team(String name) {
        this.name = name;
        this.members = new HashSet<>();
    }

    public int obtainingPoints(Player player,int score){
        player.shot(score);
        this.totalScore += score;
        return this.totalScore;
    }

    public boolean addPlayer(Player player){
        return this.members.add(player);
    }

}

