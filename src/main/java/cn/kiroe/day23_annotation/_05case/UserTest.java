package cn.kiroe.day23_annotation._05case;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author kiro
 * @description:
 * @data 15:06 8/11/2023
 **/
public class UserTest {

    public static void main(String[] args) {
        
        User user1 = new User();
        System.out.println("user1 = " + user1);
        User user = new User("张三", 20);
        System.out.println("user = " + user);

        System.out.println("user.getAge() = " + user.getAge());


    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class User{
    String name;
    int age;
}