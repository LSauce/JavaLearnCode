package cn.kiroe.day22_reflect._06customclassload;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author kiro
 * @description:
 * @data 09:58 8/11/2023
 **/
public class MyClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //
        String path = "/Volumes/data/Download/Log.class";
        CustomClassLoad customClassLoad = new CustomClassLoad(path);
        Class c = customClassLoad.loadClass("Log");
        Object o = c.newInstance();
        System.out.println("o.getClass().getClassLoader() = " + o.getClass().getClassLoader());

        Method declaredMethod = c.getDeclaredMethod("func");
        declaredMethod.invoke(o);



    }
}
