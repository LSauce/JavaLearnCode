package _02dsdb.day02_generic._01extends;

import cn.kiroe.day04.homework.CourseCode;

/*
① 泛型通配符<?>
任意类型，如果没有明确，那么就是Object以及任意的Java类了
② ? extends E
向下限定，E及其子类
③ ? super E
向上限定，E及其父类
 */
public class Demo3 {

    public static void main(String[] args) {
        Number number = new Integer(23);

        int i = number.intValue();
        // 允许接受Number及Number的子类, 返回加一后的值
        User<Integer> user = new User<>(10);
        compute(user);

        User<Double> doubleUser = new User<>(23.1);

        System.out.println("compute(doubleUser) = " + compute(doubleUser));


    }
    // User<? extends Number > 允许接受 Number及Number的子类
    public static int compute(User<? extends Number> user) {
        Number number = user.data;
        return number.intValue() + 1;
    }
}
