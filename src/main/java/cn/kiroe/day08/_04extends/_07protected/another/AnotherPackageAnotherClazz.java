package cn.kiroe.day08._04extends._07protected.another;

import cn.kiroe.day08._04extends._07protected.one.CurrentClazz;
import cn.kiroe.day08._04extends._07protected.one.SamePackageSon2Clazz;
import cn.kiroe.day08._04extends._07protected.one.SamePackageSonClazz;

/**
 * @author kiro
 * @description:
 * @data 17:39 20/10/2023
 **/
public class AnotherPackageAnotherClazz {

    public static void main(String[] args) {
        //创建父类对象
        CurrentClazz currentClazz = new CurrentClazz();
        //'a' has protected access in 'cn.kiroe.day08._04extends._07protected.one.CurrentClazz'
        //System.out.println("currentClazz.a = " + currentClazz.a);

        //创建"兄弟"对象访问
        SamePackageSon2Clazz samePackageSon2Clazz = new SamePackageSon2Clazz();
        //'a' has protected access in 'cn.kiroe.day08._04extends._07protected.one.CurrentClazz'
        //System.out.println("samePackageSon2Clazz.a = " + samePackageSon2Clazz.a);
        // 创建子类对象访问
        SamePackageSonClazz samePackageSonClazz = new SamePackageSonClazz();
       // System.out.println("samePackageSonClazz.a = " + samePackageSonClazz.a);
    }

}
