package cn.kiroe.day22_reflect.homework.reflectex;

import java.lang.reflect.Field;

/**
 * @author kiro
 * @description:
 * @data 20:02 7/11/2023
 **/
/*
3.代码补全
tips:
- 反射API
- Field

public class Work1 {
 /**
  *
  * @param targetObj  要修改成员变量值的目标对象
  * @param fieldName  对象中要修改的成员变量的名字
  * @param newValue   要修改成员变量值的新值
  */
/*
public static void setAll(Object targetObj, String fieldName, Object newValue) {

        }

 */
public class Work {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 测试 修改方法
        Student student = new Student("zs", 12);
        System.out.println("改前  student = " + student);
        Work1.setAll(student,"name","changed");
        System.out.println("改后 student = " + student);


    }
}
class Student{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String study(){
        System.out.println("偷偷学习");
        return "学习中";
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Work1 {
    /**
     * @param targetObj 要修改成员变量值的目标对象
     * @param fieldName 对象中要修改的成员变量的名字
     * @param newValue  要修改成员变量值的新值
     */

    public static void setAll(Object targetObj, String fieldName, Object newValue) throws NoSuchFieldException, IllegalAccessException {
        // 通过 反射改变值
        Class c = targetObj.getClass();
        // 后去 指定 成员变量名
        Field declaredField = c.getDeclaredField(fieldName);
        declaredField.setAccessible(true);
        declaredField.set(targetObj,newValue);

    }

}

