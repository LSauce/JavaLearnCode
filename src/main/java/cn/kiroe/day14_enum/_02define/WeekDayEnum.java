package cn.kiroe.day14_enum._02define;

/**
 * @author kiro
 * @description:
 * @data 11:18 28/10/2023
 **/

// 关键字 enum表示 一个枚举类型
public enum WeekDayEnum {
    MONDAY,
    TUESDAY,
    WEDNESAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class Demo2{
    public static void main(String[] args) {
        System.out.println("WeekDayEnum.MONDAY = " + WeekDayEnum.MONDAY);
    }
}
