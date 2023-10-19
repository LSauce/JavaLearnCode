package cn.kiroe.day06.oop1._01introduction;

/**
 * @author kiro
 * @description:
 * @data 15:19 17/10/2023
 **/
public class Demo {
    //张三养了3只狗，一只1岁白色萨摩亚，一只2岁黄白柯基，一只3岁黄色金毛
    public static void main(String[] args) {
        //第一只狗：
        Dog dog1 = new Dog("samoya", "white", 2);
        Dog dog2 = new Dog("keji", "yello and white", 33);
        Dog dog3 = new Dog("gold", "yello", 23);
        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println(dog3);

    }


}

class Dog {
    private String name;
    private String color;
    private int age;

    private String kind;

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Dog(String name, String color, int age, String kind) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.kind = kind;
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", kind='" + kind + '\'' +
                '}';
    }
}
