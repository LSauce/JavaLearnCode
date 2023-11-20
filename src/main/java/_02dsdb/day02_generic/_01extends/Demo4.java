package _02dsdb.day02_generic._01extends;

public class Demo4 {

    public static void main(String[] args) {
        // 再Java中泛型 不是真的泛型，是假的
        User<Integer> integerUser = new User<>(12);
        User<String> stringUser = new User<>("fda");
        System.out.println("integerUser.data = " + integerUser.data);
        System.out.println("stringUser = " + stringUser);

    }
}
