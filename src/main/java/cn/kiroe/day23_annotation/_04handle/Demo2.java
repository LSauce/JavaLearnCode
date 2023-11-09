package cn.kiroe.day23_annotation._04handle;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

// AgeLimit    属性 maxAge  minAge
@Retention(RetentionPolicy.RUNTIME)
@interface AgeLimit {
    int maxAge() default 100;

    int minAge() default 0;
}

//
// NameLimit  属性  length ，名字长度不超过5
@Retention(RetentionPolicy.RUNTIME)
@interface NameLimit {
    int length() default 5;
}

/**
 * @author kiro
 * @description:
 * @data 14:31 8/11/2023
 **/

/*
练习:

定义2个注解

AgeLimit    属性 maxAge  minAge

NameLimit  属性  length

定义学生类Student  年龄18-25之间   名字长度不超过5
 */
public class Demo2 {

    public static void main(String[] args) throws Exception {
        Student student = StudentFactory.getInstance("zs1", 230);
        System.out.println("student = " + student);
    }
}

// 使用 简单工厂获取对象
class StudentFactory {

    private static Class stuCls;

    static {
        try {
            stuCls = Class.forName("cn.kiroe.day23_annotation._04handle.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Student getInstance(String name, int age) throws Exception {
        // 对name 进行校验
        // 对age进行校验


            judgeName(name);
            judgeAge(age);

            // return 一个学生对象
            // 通过Class对象获取构造器对象
            // 实例化对象
            // 使用反射获取 对象
            Constructor declaredConstructor = stuCls.getDeclaredConstructor(String.class, int.class);
            declaredConstructor.setAccessible(true);
            Object o = declaredConstructor.newInstance(name, age);
            return (Student) o;


    }

    private static void judgeAge(int age) throws NoSuchFieldException {
        Field ageField = stuCls.getDeclaredField("age");

        if (ageField.isAnnotationPresent(AgeLimit.class)) {
            AgeLimit annotation = ageField.getAnnotation(AgeLimit.class);
            System.out.println(annotation.maxAge());
            annotation.minAge();
            if (age < annotation.minAge() || age > annotation.maxAge()) {
                throw new IllegalArgumentException("age 范围为：[" + annotation.minAge() + "," + annotation.maxAge() + "]");
            }
        }
    }

    private static void judgeName(String name) throws NoSuchFieldException {
        Field nameField = stuCls.getDeclaredField("name");
        boolean annotationPresent = nameField.isAnnotationPresent(NameLimit.class);
        if (annotationPresent) {
            // 获取注解
            NameLimit annotation = nameField.getAnnotation(NameLimit.class);
            int length = annotation.length();
            if (name.length() > length) {
                throw new IllegalArgumentException("姓名长度应该在" + length + "以内");
            }
        }
    }


}

// 定义学生类Student  年龄18-25之间   名字长度不超过5
class Student {
    @NameLimit()
    String name;
    @AgeLimit()
    int age;

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
