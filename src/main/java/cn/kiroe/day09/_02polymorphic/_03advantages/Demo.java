package cn.kiroe.day09._02polymorphic._03advantages;

/**
 * @author kiro
 * @description:
 * @data 17:52 23/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
        Timo timo = new Timo("Timo", "种蘑菇");
        EZ ez = new EZ("EZ", "精准弹幕");
        timo.skill();
        ez.skill();

        Hero heor;
        heor = timo;
        heor.skill();
        heor = ez;
        heor.skill();
    }
}
class Hero{

    String name;
    String skillR;
    public void skill(){
        System.out.println(this.name +"使用了终极技能"+ this.skillR);
    }

    public Hero(String name, String skillR) {
        this.name = name;
        this.skillR = skillR;
    }
}
class Timo extends Hero{

    public Timo(String name, String skillR) {
        super(name, skillR);
    }
}

class EZ extends Hero{
    public EZ(String name, String skillR) {
        super(name, skillR);
    }
}
