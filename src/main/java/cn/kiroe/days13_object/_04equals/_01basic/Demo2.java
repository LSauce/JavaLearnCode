package cn.kiroe.days13_object._04equals._01basic;

import java.util.Objects;

/**
 * @author kiro
 * @description:
 * @data 16:23 27/10/2023
 **/
public class Demo2 {
    public static void main(String[] args) {
        Father father = new Father("zs");
        Son son = new Son("zs");
        System.out.println("father.equals(son) = " + father.equals(son));
    }
}

class Father{
    String name;

    public Father(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || ! (object instanceof Father) ) return false;

        Father father = (Father) object;

        return Objects.equals(name, father.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

class Son extends Father{
    public Son(String name) {
        super(name);
    }
}
