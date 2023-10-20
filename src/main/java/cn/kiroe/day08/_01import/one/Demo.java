package cn.kiroe.day08._01import.one;

import org.junit.Test;
//想要使用其他包中的类需要 导包
//import cn.kiroe.day08._01import.another.Student;
// 只能导入 import java.*
//fasdf
import java.util.*;// 只能导入 只加载使用类型，懒加载

// lazy loading 懒加载
/**
 * @author kiro
 * @description:
 * @data 10:15 20/10/2023
 **/
public class Demo {

    @Test
    public void test(){
        // 默认使用 同包下的类
        Student student = new Student();
        student.test();
        // 或者使用全限定类名
        cn.kiroe.day08._01import.another.Student s2 = new cn.kiroe.day08._01import.another.Student();
        s2.test();
    }
}
