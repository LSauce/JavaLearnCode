package cn.kiroe.day22_reflect._04api;

import cn.kiroe.day22_reflect._04api.bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author kiro
 * @description:
 * @data 17:16 7/11/2023
 **/
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 反射的 起点  是 字节码文件对象
        // 获取 字节码文件对象
        Class c = Person.class;
        // 获取 所有的public 构造方法
        // Constructor[] getConstructors()
        Constructor[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }
        // 获取所有的构造方法
        // Constructor[] getDeclaredConstructors()
        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }
        // 获取指定的 构造方法
        Constructor constructor = c.getConstructor(String.class, int.class, boolean.class);
        System.out.println("constructor = " + constructor);
        Constructor constructor1 = c.getConstructor();
        System.out.println("constructor1 = " + constructor1);
        // 获取指定构造方法
        Constructor declaredConstructor = c.getDeclaredConstructor(String.class);
        System.out.println("declaredConstructor = " + declaredConstructor);

        // 通过 constructor对象 来创建对象
        // newInstance(参数列表)
        Person person = (Person) constructor1.newInstance();
        System.out.println("person = " + person);
        Object o = constructor.newInstance("zs", 23, false);
        System.out.println("o = " + o);
        // 私有构造器，没有权限
        // 忽略java 权限检测
        declaredConstructor.setAccessible(true);
        Object o1 = declaredConstructor.newInstance("李四");
        System.out.println("o1 = " + o1);

        // 静态方法测试
        Method test = c.getMethod("test");
        test.invoke(new Object());


    }


}

