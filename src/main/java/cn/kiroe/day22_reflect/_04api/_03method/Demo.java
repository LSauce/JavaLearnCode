package cn.kiroe.day22_reflect._04api._03method;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author kiro
 * @description:
 * @data 17:42 7/11/2023
 **/
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c = ClassLoader.getSystemClassLoader().loadClass("cn.kiroe.day22_reflect._04api.bean.Person");
        // Method[] getMethods()// 父类的也能获取到
        for (Method method : c.getMethods()) {
            System.out.println("method = " + method);
        }
        // Method[] getDeclaredMethods() // 只会获取自己的
        for (Constructor declaredConstructor : c.getDeclaredConstructors()) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }

        // 获得指定public的方法
        //Method getMethod(String name, Class<?>... parameterTypes)
        Method eatMethod1 = c.getMethod("eat");
        System.out.println("eatMethod1 = " + eatMethod1);
        // Method getDeclaredMethod(String name, Class<?>... parameterTypes)
        Method eatMethod2 = c.getDeclaredMethod("eat", String.class);
        System.out.println("eatMethod2 = " + eatMethod2);
        // Object invoke(Object obj, Object... args)
        System.out.println("执行方法");
        // 需要基于对象，可获取返回值
        Constructor declaredConstructor = c.getDeclaredConstructor();
        Object o = declaredConstructor.newInstance();
        eatMethod1.invoke(o);
        eatMethod2.setAccessible(true);
        eatMethod2.invoke(o,"apple");

        Method sleepMethod = c.getDeclaredMethod("sleep");
        System.out.println("sleepMethod.invoke(o) = " + sleepMethod.invoke(o));
    }
}
