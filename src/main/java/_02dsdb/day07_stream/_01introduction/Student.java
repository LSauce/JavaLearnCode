package _02dsdb.day07_stream._01introduction;

import java.util.Objects;

/**
 * @author kiro
 * @description:
 * @data 11:01 16/11/2023
 **/
public class Student {
    private String name;
    private int age;
    private int height;
    private Address address;

    public Student(String name, int age, int height, Address address) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    // todo getter & setter

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (height != student.height) return false;
        if (!Objects.equals(name, student.name)) return false;
        return address == student.address;
    }

    // hashcode & equals

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + height;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", address=" + address +
                '}';
    }

    public enum Address {
        BJ, SH, WH, SZ
    }
}
