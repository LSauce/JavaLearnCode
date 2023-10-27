package cn.kiroe.days12.oop._01intern._07method;

/**
 * @author kiro
 * @description:
 * @data 11:12 27/10/2023
 **/

/*
Lambda表达式的主体只有1条语句时, 程序不仅可以省略主体的大括号,
还可以通过英文双冒号::的语法来引用方法, 进一步简化Lambda表达式的书写.

什么样的方法，能够作为方法引用指向的功能接口中抽象方法的实现？
只看三点：
1. 返回值类型必须一致。
2. (方法签名method signature一致)形参列表中的数量，类型，位置必须都对应上，
形参名字无所谓。
3. 方法的名字无所谓。
 */
/*
1.静态方法引用

2.对象名引用成员方法
3.类名引用成员方法
4.构造方法引用
 */
public class Demo {
    public static void main(String[] args) {
        // 静态方法引用
        // lambda写法
        IA ia2 = () -> System.out.println(111);
        ia2.testA();


        IA ia = () -> A.func1();
        ia.testA();
        // 方法引用
        IA ia1 = A::func1;
        ia1.testA();


        // 对象名引用成员方法
        // lambda
        IC ic2 = a ->
            System.out.println(a);

        ic2.testC(1);

        IC ic =  a -> new C().func2(a);
        ic.testC(100);
        // 方法引用
        IC ic1 = new C()::func2;
        ic1.testC(200);


        //IB ib = s -> System.out.println(s);
        //ib.testB("aaa");

        // 可以指向源码中的方法或者第三方工具的方法
        IB ib = System.out::println;
        ib.testB("aaa");
        // (x,y,z) -> x.方法(第二个参数,第三个参数)
        // 第一个对象参数.方法名(第二个参数,第三个参数)
        // 直接传入 第一个参数::方法名

        // "abcdef", 希望对字符串进行截取"bc"
        // 主要使用String类中的成员方法
        // subString( int start,int end)  [start,end)
        //String s = "abcdef";
        //String substring = s.substring(1, 3);
        //System.out.println("substring = " + substring);


        // 类名引用成员方法
        // lambda
        ID id = (s, start, end) -> s.substring(start, end);
        String str = id.testD("abcdef", 1, 3);
        System.out.println("str = " + str);
        System.out.println("((ID)String::substring).testD(\"test\",1,2) = " + ((ID) String::substring).testD("test", 1, 2));
        // 简化
        ID id2 = String::substring;
        // 使用
        String str2 = id2.testD("abcdef", 1, 3);
        System.out.println("str2 = " + str2);


        // 4.构造方法引用
        // lambda表达式
        // 有参构造
        IE ie = (String name, int age) -> new Dog(name, age);
        Dog dog = ie.getDog("小黑", 3);
        System.out.println(dog);
        // 无参构造
        IG ig = () -> new Dog();
        Dog dog1 = ig.getDog();
        System.out.println(dog1);
        // 方法引用
        IE ie2 = Dog::new;
        Dog dog2 = ie2.getDog("小花", 4);
        System.out.println(dog2);

        IG ig2 = Dog::new;
        Dog dog3 = ig2.getDog();
        System.out.println(dog3);
        // 接口返回值 为 void也可以，相当于当普通类使用
        IH ih = Void::new;
        ih.getVoid("2","3");


    }
}

@FunctionalInterface
interface IA{
    void testA();
}

class A {
    // 定义一个静态方法 作为IA接口中的testA方法的实现
    static void func1(){
        System.out.println("IA接口中的testA方法的实现");
    }
}

@FunctionalInterface
interface IB{
    void testB(String s);
}

@FunctionalInterface
interface IC{
    void testC(int a);
}

class C {
    void func2(int m){
        System.out.println(m);
    }
}

@FunctionalInterface
interface ID{
    String testD(String s, int start, int end);
}

@FunctionalInterface
interface IE{
    Dog getDog(String a, int b);
}

@FunctionalInterface
interface IG{
    Dog getDog();
}


class Dog{
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog() {
    }
}


interface IH{

    void getVoid(String a,String b);
}

class Void{
    String a;
    String b;

    public Void(String a, String b) {
        this.a = a;
        this.b = b;

        System.out.println(a + b);
    }
}