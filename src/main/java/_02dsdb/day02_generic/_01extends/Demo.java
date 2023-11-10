package _02dsdb.day02_generic._01extends;

public class Demo {

    public static void main(String[] args) {
        System.out.println("test");
        User<Integer> integerUser = new User<>(1);
        printUser(integerUser);


    }

    public static void printUser(User<Integer> integerUser){
        System.out.println("integerUser.data = " + integerUser.data);
    }
}


class User<T>{
    T data;

    public User(T data) {
        this.data = data;
    }
}
