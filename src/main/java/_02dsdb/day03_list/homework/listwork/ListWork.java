package _02dsdb.day03_list.homework.listwork;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 13:55 11/11/2023
 **/

// 2, 如果List中存储了多个User对象,
// 去除重复元素(多个重复元素仅保留一个)
// (假设使用Collection和List的api)
public class ListWork {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        initUserList(users);
        System.out.println("users = " + users);
        //  如果List中存储了多个User对象,
        // // 去除重复元素(多个重复元素仅保留一个)
        // 重写equal，以id为标准，判断是否重复
        List<User> noRepeatUsers1 = removeRepeatElement(users);
        System.out.println("noRepeatUsers1 = " + noRepeatUsers1);

    }

    private static<T> List<T> removeRepeatElement(List<T> users) {
        if(users == null){
            return null;
        }
        // 使用 list储存结果
        ArrayList<T> result = new ArrayList<>();
        for (T user : users) {
            if(!result.contains(user)){
                result.add(user);
            }
        }

        return result;
    }


    private static void initUserList(ArrayList<User> users) {
        users.add(new User(1, "zs", 10));
        users.add(new User(2, "zs1", 110));
        users.add(new User(3, "zs2", 120));
        users.add(new User(4, "zs3", 130));
        users.add(new User(4, "zs4", 110));
        users.add(new User(5, "zs5", 110));
    }
}

class User {
    private int id;// 以id为准，判断是否重复
    private String name;
    @Getter
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
