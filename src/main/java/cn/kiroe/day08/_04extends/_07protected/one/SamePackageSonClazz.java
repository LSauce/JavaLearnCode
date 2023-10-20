package cn.kiroe.day08._04extends._07protected.one;

/**
 * @author kiro
 * @description:
 * @data 17:38 20/10/2023
 **/
public class SamePackageSonClazz extends CurrentClazz{

    public static void main(String[] args) {
        //创建父类对象
        CurrentClazz currentClazz = new CurrentClazz();
        System.out.println("currentClazz.a = " + currentClazz.a);
        //创建"兄弟"对象访问
        SamePackageSon2Clazz samePackageSon2Clazz = new SamePackageSon2Clazz();
        System.out.println("samePackageSon2Clazz.a = " + samePackageSon2Clazz.a);
        // 创建子类对象访问
        SamePackageSonClazz samePackageSonClazz = new SamePackageSonClazz();
        System.out.println("samePackageSonClazz.a = " + samePackageSonClazz.a);
    }
}
