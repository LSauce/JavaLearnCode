package cn.kiroe;

import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTest {
    /*
    @BeforeClass
    static void  beforeClassTest(){
        System.out.println("beforeClassTest");
    }*/
    @Test
    public void test(){
        System.out.println("Test JUnit");
    }

    @Test
    public void arrayTest(){
        char[] cs = new char[10];
        System.out.println((int) cs[0]);
        boolean[] bs = new boolean[2];
        System.out.println(bs[0]);
    }

    @Test
    public void test2(){
        label:while (true){
           label2:while (true){
                break label;

            }

        }
        label:do {
           label2: do {
                break label2;
            }while (true);
        }while (true);

    }







}
