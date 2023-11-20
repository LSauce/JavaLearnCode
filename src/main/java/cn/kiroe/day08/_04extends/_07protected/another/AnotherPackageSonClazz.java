package cn.kiroe.day08._04extends._07protected.another;

import cn.kiroe.day08._04extends._07protected.one.CurrentClazz;
import cn.kiroe.day08._04extends._07protected.one.SamePackageSon2Clazz;
import cn.kiroe.day08._04extends._07protected.one.SamePackageSonClazz;

/**
 * @author kiro
 * @description:
 * @data 17:39 20/10/2023
 **/

/*
protected
在同类、同包下是可以随意访问的。
在不同包下，只有在子类中 创建 该子类对象，才能访问 protected 成员
 */
public class AnotherPackageSonClazz extends CurrentClazz {

    public static void main(String[] args) {
        //创建父类对象
        CurrentClazz currentClazz = new CurrentClazz();
       // System.out.println("currentClazz.a = " + currentClazz.a);
        //创建"兄弟"对象访问
        SamePackageSon2Clazz samePackageSon2Clazz = new SamePackageSon2Clazz();
       // System.out.println("samePackageSon2Clazz.a = " + samePackageSon2Clazz.a);
        // 创建子类对象访问 - 不同包下 只能使用 该子类自身对象使用 protected的成员
        AnotherPackageSonClazz anotherPackageSonClazz = new AnotherPackageSonClazz();
        System.out.println("anotherPackageSonClazz.a = " + anotherPackageSonClazz.a);
    }
}
