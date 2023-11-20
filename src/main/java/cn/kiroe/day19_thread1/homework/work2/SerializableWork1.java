package cn.kiroe.day19_thread1.homework.work2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 19:12 3/11/2023
 **/
/*
序列化与反序列化练习
定义1个User类
    成员变量:
        用户编号: int id;
        用户名  : String name;
        用户手机: String mobile;
        用户地址: Address address;
定义1个Address类
    成员变量
        详细地址: String detail;
        邮政编码: String code;
需求:实现序列化与反序列化操作
1.创建User对象,序列化保存到某个文件,反序列化读取文件还原为User对象并打印
2.创建User[]对象,将数组对象序列化到某个文件,反序列化还原User[]对象并打印
 */
public class SerializableWork1 {
    public static void main(String[] args) {
        // serializeObject();
        serializeArrayObject();
    }

    private static void serializeArrayObject() {
        // 2.创建User[]对象,将数组对象序列化到某个文件,反序列化还原User[]对象并打印
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User(i + 1, "张" + 'i', "11" + "i", new Address("武汉", "911"));
            list.add(user);
        }
        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("userArr.obj"));
             ObjectInput input = new ObjectInputStream(new FileInputStream("userArr.obj"))) {

            // 序列化
            output.writeObject(list.toArray(new User[0]));
            output.flush(); // 有缓存 1024
            // 读取：
            User[] users = (User[]) input.readObject();
            System.out.println(" Arrays.toString(users) = " + Arrays.toString(users));


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void serializeObject() {
        // 需求:实现序列化与反序列化操作
        // 1.创建User对象,序列化保存到某个文件,反序列化读取文件还原为User对象并打印
        User user = new User(1, "张三", "110", new Address("武汉", "911"));
        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("user.obj"));
             ObjectInput input = new ObjectInputStream(new FileInputStream("user.obj"))) {

            // 序列化
            output.writeObject(user);
            output.flush(); // 有缓存 1024
            // 读取：
            User user1 = (User) input.readObject();
            System.out.println("user1 = " + user1);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
定义1个User类
    成员变量:
        用户编号: int id;
        用户名  : String name;
        用户手机: String mobile;
        用户地址: Address address;
定义1个Address类
 */

class User implements Serializable {
    private static final long serialVersionUID = 2186282295696475224L;
    private int id;
    private String name;
    private String mobile;
    private Address address;

    public User(int id, String name, String mobile, Address address) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address=" + address +
                '}';
    }
}
