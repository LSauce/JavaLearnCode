package cn.kiroe.day23_annotation._04handle;

import cn.kiroe.day22_reflect._06customclassload.Log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * @author kiro
 * @description:
 * @data 11:48 8/11/2023
 **/

/*

利用反射--获取注解信息

 */
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        // 获取字节码文件对象
        Class c = Class.forName("cn.kiroe.day23_annotation._04handle.Demo");

        Method declaredMethod = c.getDeclaredMethod("login");
        // 判断方式上面是否使用了注解
        boolean annotationPresent = declaredMethod.isAnnotationPresent(Login.class);
        if(annotationPresent){
            // 如果使用了注释获取注解信息
            // 获取注解实例
            Login annotation = declaredMethod.getAnnotation(Login.class);
            // 获取注解属性值
            System.out.println("annotation.name() = " + annotation.name());
            System.out.println("annotation.password() = " + annotation.password());
            // do sth


        }else {
            System.out.println("没有使用注解");
        }
    }

    @Login
    public  void login(){

    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Login{

    String name() default "admin";
    String password() default "123456";
}
