package cn.kiroe.day14_enum._02define;

/**
 * @author kiro
 * @description:
 * @data 11:11 28/10/2023
 **/

/*
- 自定义类实现枚举
- 使用Enum关键字实现枚举

### 自定义类实现枚举
1. 构造方法私有, 不允许外部创建对象, 类内部可以创建, 保证数量是固定的
2. 枚举对象名通常使用大写
3. 对枚举对象(属性)使用static final修饰, 保证是常量, 能够通过类名去访问(暴露给外部访问的一个入口)
4. 不需要提供setXXX()方法, 枚举对象通常为只读
 */
public class Demo {


}

class WeekDay{
    //定义几个 固定常量对象
    final public static WeekDay MONDAY = new WeekDay("周一",1);
    final public static WeekDay TUESDAY = new WeekDay("周二",2);
    final public static WeekDay WEDNESDAY = new WeekDay("周三",3);
    final public static WeekDay THURSDAY = new WeekDay("周四",4);
    final public static WeekDay FRIDAY = new WeekDay("周五",5);
    final public static WeekDay SATURDAY = new WeekDay("周六",6);
    final public static WeekDay SUNDAY = new WeekDay("周七",7);

    String name;
    int id;

    private WeekDay(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static WeekDay getInstance(String name,int id){

        return null;
    }
}


