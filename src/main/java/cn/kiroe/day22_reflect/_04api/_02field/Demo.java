package cn.kiroe.day22_reflect._04api._02field;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author kiro
 * @description:
 * @data 17:32 7/11/2023
 **/
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取字节码文件对象
        Class c = Class.forName("cn.kiroe.day22_reflect._04api.bean.Person");
        // 获取所有的public 成员变量
        // Field[] getFields()
        System.out.println("---获取所有的public 成员变量---");
        for (Field field : c.getFields()) {
            System.out.println("field = " + field);
        }
        // 获取所有的成员变量
        // Field[] getDeclaredFields()
        System.out.println("---获取所有的成员变量---");
        for (Field declaredField : c.getDeclaredFields()) {
            System.out.println("declaredField = " + declaredField);
        }
        // 获取指定的public 成员变量
        // Field getField(String name)
        System.out.println("---获取指定的public 成员变量---");
        Field nameField = c.getField("name");
        System.out.println("nameField = " + nameField);
        // Field getDeclaredField(String name)
        // 获取指定的成员变量
        Field ageField = c.getDeclaredField("age");
        System.out.println("ageField = " + ageField);

        // void set(Object obj, Object value)：赋值，传入对象
        // 获取对象
        Constructor declaredConstructor = c.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Object o = declaredConstructor.newInstance("zs");

        nameField.set(o,"ls");
        ageField.setAccessible(true);
        ageField.set(o,23);

        System.out.println("o = " + o);
        // Object get(Object obj)：获取值，传入对象

    }
}
