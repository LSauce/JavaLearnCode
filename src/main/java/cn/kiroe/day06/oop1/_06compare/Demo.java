package cn.kiroe.day06.oop1._06compare;

/**
 * @author kiro
 * @description:
 * @data 10:08 18/10/2023
 **/
public class Demo {
    /*
    局部变量和成员变量的比较，我们从以下五个方面去比较：

1. 在类中定义的位置不同
    局部位置： 局部
    成员： 成员
2. 在内存中的位置不同
    局部: 栈 栈帧中
    成员： 堆 对象上
3. 生命周期不同
    局部： 和栈帧同生共死
    成员： new开始，被gc回收结束，和对象同生共死，依赖于对象
4. 有无默认初始化不同
    局部： 无初始化
    成员： 有初始化
5. 作用范围
    局部： 局部所在代码块
    成员： 类所在代码块,除静态方法类中
     */
    public static void main(String[] args) {

    }
}
