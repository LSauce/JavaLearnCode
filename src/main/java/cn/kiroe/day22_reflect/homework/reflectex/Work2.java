package cn.kiroe.day22_reflect.homework.reflectex;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author kiro
 * @description:
 * @data 20:08 7/11/2023
 **/
/*4.完成如下方法，要求该方法能调用，指定配置文件中，指定类中指定的普通成员方法(无参方法)
        假设指定类中一定有默认构造方法
        tips:
        - Properties
        - 反射API
        - Method
        properties配置文件中内容如下:
        className=com.cskaoyan.day22.Student
        methodName=study
*/
public class Work2 {

    public static void main(String[] args) {
        callTargetMethod("src/main/resources/class.properties");
    }

    /**
     * 要求该方法能调用，指定配置文件中，指定类中指定的普通成员方法(无参方法)
     *
     * @param configFilePath 表示配置文件的路径
     */
    public static void callTargetMethod(String configFilePath) {
        // 获取指定类
        Properties properties = new Properties();

        try {
            properties.load(new BufferedReader(new FileReader(configFilePath)));
            // 获得全限定名
            String className = properties.getProperty("className");
            // 获得方法名
            String methodName = properties.getProperty("methodName");
            // 利用反射调用方法
            // 获取 类字节码对象
            Class c = Class.forName(className);
            // 创建对象
            Constructor declaredConstructor = c.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            Object o = declaredConstructor.newInstance();
            // 获取方法对象
            Method declaredMethod = c.getDeclaredMethod(methodName);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(o);
            System.out.println("输出为" + invoke);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
