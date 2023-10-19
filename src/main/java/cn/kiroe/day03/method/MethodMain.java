package cn.kiroe.day03.method;

/*
全限定类名(全类名) -----> 带包名的类名
String --> 简单类名
java.lang.String -->全限定类名


 */
public class MethodMain {

    void testOverload(){
        test(10.0,10);
    }
    void test(double d, int i){}

    void test(int i,double d){}
    public static void main(String[] args) {

        System.out.println(add(23,23));
        //方法签名：
        add(1 ,1);

        //快速生成方法
        test3("a","b");
        byte b =1;
        int a  = max(b ,3);

        //方法重载： 就近原则 范围最近的,只能有小变大
        show(1.9); // 调用double的
        show(2f);   //调用float的
        short sh = 2;
        show(sh); //调用 int的

    }
    private static void show(byte b){

    }
    private static void show(int a){

    }
    private static void show(double d) {
        System.out.println(d);
    }
    private static void show(float f){
        System.out.println(f);
    }


    private static int max(float i, int i1) {
        return 0;
    }

    private static void test3(String a, String b) {
    }

    //方法声明：
    public static int add(int n1,int n2){
        return n1 + n2;
    }


}
