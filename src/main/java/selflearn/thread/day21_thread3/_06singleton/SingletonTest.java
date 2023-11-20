package selflearn.thread.day21_thread3._06singleton;


/**
 * @author kiro
 * @description:
 * @data 16:25 6/11/2023
 **/
public class SingletonTest {

    public static void main(String[] args) {
        SingletonClass instance = SingletonClass.getInstance();
        instance.todoSomeThing();
    }

}

class SingletonClass{

    private static SingletonClass instance;

    private SingletonClass(){

    }

    public static SingletonClass getInstance(){
        // 增强效率
        if(instance == null){
            synchronized (SingletonClass.class){
                if(instance == null){
                    instance = new SingletonClass();
                }
            }
        }

        return instance;
    }

    public void todoSomeThing(){
        System.out.println("to do ");
    }


}
