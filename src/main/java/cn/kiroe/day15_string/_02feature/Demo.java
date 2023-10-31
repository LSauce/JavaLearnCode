package cn.kiroe.day15_string._02feature;

import javax.print.attribute.standard.Fidelity;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 09:53 30/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
        // 创建 Scanner 对象
        Scanner scanner = new Scanner(System.in);
        // nextLine接收数据
        String s = scanner.nextLine();
        // 使用temp引用指向
        String temp = s;
        // 通过 temp修改字符串内容

        // 打印
    }



}

class ConstructorTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InvocationTargetException {
        // 反射技术的起点 获取字节码文件对象
        Class<?> strCls = Class.forName("".getClass().getName());

        System.out.println("获取所有的public的构造方法----");
        // Constructor[] getConstructors()
        Constructor<?>[] constructors = strCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("获取所有的构造方法----");

        //Constructor[] getDeclaredConstructors()
        Constructor<?>[] declaredConstructors = strCls.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor);
        }
       /* System.out.println("获取指定的public的构造方法----");
        // Constructor<T> getConstructor(Class<?>... parameterTypes)
        Constructor<?> constructor = stuCls.getConstructor(String.class, int.class, boolean.class);
        //Constructor<?> constructor = stuCls.getConstructor(String.class, int.class);
        // java.lang.NoSuchMethodException


        System.out.println(constructor);
        System.out.println("获取指定的构造方法----");
        //Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
        Constructor<?> declaredConstructor = stuCls.getDeclaredConstructor(String.class, int.class);
        System.out.println(declaredConstructor);
        */
        Constructor<?> constructor = strCls.getDeclaredConstructor(String.class);

        // 使用构造方法对象创建对象
        // newInstance
        Object o = constructor.newInstance("1234567");
        System.out.println(o);
        System.out.println("字段");
        Field[] fields = strCls.getFields();
        System.out.println("fields = " + fields);
        for (Field field : fields) {
            System.out.println(field);
        }
        // java.lang.IllegalAccessException
        // setAccessible(true)  忽略java语法检查
        /*declaredConstructor.setAccessible(true);
        Object o1 = declaredConstructor.newInstance("ls", 21);
        System.out.println(o1);*/


    }
}
