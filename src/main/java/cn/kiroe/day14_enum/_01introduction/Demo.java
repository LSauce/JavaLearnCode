package cn.kiroe.day14_enum._01introduction;

/**
 * @author kiro
 * @description:
 * @data 11:06 28/10/2023
 **/

/*

定义一个表示星期的类WeekDay, 定义2个属性

String name: 表示是周几

int  id: 表示编号(1-7)

创建并打印相应的对象
 */
public class Demo {

    public static void main(String[] args) {
       // WeekDay monday = new WeekDay("周一",1);
        //WeekDay sunday = new WeekDay("周日",2);
        //WeekDay eight = new WeekDay("周八",8);

        //System.out.println(sunday);
    }

}

class WeekDay{
    String name;
    int id;

    private WeekDay(String name, int id) {
        this.name = name;
        this.id = id;

    }

    public static WeekDay getInstance(String name,int id){
        return new WeekDay(name,id);
    }

    @Override
    public String toString() {
        return "WeekDay{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
