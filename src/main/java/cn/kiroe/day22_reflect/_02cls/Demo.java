package cn.kiroe.day22_reflect._02cls;

/**
 * @author kiro
 * @description:
 * @data 16:06 7/11/2023
 **/
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException {
        Student student = new Student();
        // 对象.getClass()
        Class c1 = student.getClass();
        // 类名.class
        Class c2 = Student.class;
        System.out.println(c1 == c2);
        // - Class.forName(String className)  全限定名
        Class c3 = Class.forName("cn.kiroe.day22_reflect._02cls.Student");
        System.out.println(c1 == c3);

        // - ClassLoader里的loadClass(String className)
        Class c4 = ClassLoader.getSystemClassLoader().loadClass("cn.kiroe.day22_reflect._02cls.Student");
        System.out.println(c1 == c4);


    }
}


class Student {

}