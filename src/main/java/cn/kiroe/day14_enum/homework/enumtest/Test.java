package cn.kiroe.day14_enum.homework.enumtest;

/**
 * @author kiro
 * @description:
 * @data 14:34 28/10/2023
 **/
//定义一个枚举类型Season来描述季节, 结合switch语句, 根据传入的枚举类型, 输出打印相应的季节
enum Seanson {
        SPRING("spring",1,"春天"),
        Summer("Summer",2,"夏天"),
        Autumn("Autumn",3,"秋天"),
        Winter("Winter",4,"冬天");
        String name;
        int id;
        String label;

    Seanson(String name, int id, String label) {
        this.name = name;
        this.id = id;
        this.label = label;
    }
}

public class Test {

    public static void main(String[] args) {
        Seanson seanson = Seanson.Autumn;
        dealSeason(seanson);

    }

    public static void dealSeason(Seanson seanson){

        switch (seanson){
            case SPRING:
                System.out.println("现在是"+Seanson.SPRING.label);
                break;
            case Summer:
                System.out.println("现在是"+Seanson.Summer.label);
                break;
            case Autumn:
                System.out.println("现在是"+Seanson.Autumn.label);
                break;
            case Winter:
                System.out.println("现在是"+Seanson.Winter.label);
                break;
        }
    }

}
