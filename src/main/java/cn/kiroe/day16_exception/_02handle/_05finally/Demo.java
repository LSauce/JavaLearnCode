package cn.kiroe.day16_exception._02handle._05finally;

/**
 * @author kiro
 * @description:
 * @data 14:55 31/10/2023
 **/

/*

语法:方式一
try{

}catch(){

}catch(){

}.....
finally{
    // 一定执行
}

方式二:
try{

}finally{

}
 */
public class Demo {
    public static void main(String[] args) {
        try {
            System.out.println(1/0);
        }catch (Exception e){
            System.out.println("test");
            return;
        }finally {
            System.out.println("执行了");
        }

        System.out.println("main end");
    }
}
