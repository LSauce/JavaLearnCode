package cn.kiroe.day02;
/*
*   注释：
*   1. 单行
*   2. 多行
*   3. 文档
*
* */

/**
 * 注释测试类
 */
public class AnnotationMain {

    public static void main(String[] args) {

        //单行：
//        System.out.println("单行注释");
        //多行注释：
        /*
        System.out.println("多行注释");
         */


        //文档
       /* /**
         *
         */
        //特点: 不参加 编译
        //优点：增加代码可读性
        //理清 代码 思路 ---> 逻辑
        //写清步骤






    }


}

/**
 *  文档测试类Demo
 */
class Demo{
    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("test");
    }

    /**
     * 测试方法
     */
    public static void test(){
        System.out.println("测试方法");
    }
}
