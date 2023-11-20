package cn.kiroe.day07.oop2._01game._02pvz;

/**
 * @author kiro
 * @description:
 * @data 10:58 19/10/2023
 **/
public class Plant {
    //血量，攻击力，价格
    private int hp;
    private int attackPower;
    private int cost;


    public Plant(int hp, int attackPower, int cost) {
        this.hp = hp;
        this.attackPower = attackPower;
        this.cost = cost;
    }
}
