package cn.kiroe.day23_annotation._02define;

/**
 * @author kiro
 * @description:
 * @data 11:20 8/11/2023
 **/

/*
权限修饰符 @interface 注解名字{
    // 注解体定义
    属性类型 属性名();
    属性类型 属性名();
    属性类型 属性名();
    ......
}
举例:
public @interface Override {
}

属性类型:
基本数据类型
String类型
Class类型
注解类型
枚举类型
以及以上类型的数组形式
 */
@interface MyAnnotation {

    // 注解题
    // 属性类型 属性名()
    int attribute1();// 抽象法发
    String attribute2();
    Class attributes3();
    
     int a = 0; // 静态常量成员

    MyAnnotation2 attributes4();
}

@interface MyAnnotation2{

}
// 注解没有继承
// @interface may not have extends list
// @interface Myanno3 extends MyAnnotation2{
//
// }


enum Season{
    SPRING,
    SUMMER
}