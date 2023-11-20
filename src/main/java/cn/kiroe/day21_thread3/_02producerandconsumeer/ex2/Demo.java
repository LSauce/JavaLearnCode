package cn.kiroe.day21_thread3._02producerandconsumeer.ex2;

/**
 * @author kiro
 * @description:
 * @data 11:16 6/11/2023
 **/
/*
将循环 放 锁里面
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Container container = new Container();
        ProducerTask producerTask = new ProducerTask(container);
        ProducerTask producerTask1 = new ProducerTask(container);
        ProducerTask producerTask2 = new ProducerTask(container);
        ConsumerTask consumerTask = new ConsumerTask(container);
        ConsumerTask consumerTask1 = new ConsumerTask(container);
        ConsumerTask consumerTask2 = new ConsumerTask(container);
        new Thread(consumerTask, "消费者1").start();
        new Thread(consumerTask1, "消费者2").start();
        // new Thread(consumerTask2, "消费者3").start();
        new Thread(producerTask, "生产者1").start();
        new Thread(producerTask1, "生产者2").start();
        // new Thread(producerTask2, "生产者3").start();
    }


}

// 生产者类
class ProducerTask implements Runnable {
    Container container;

    Food[] foods = {
            new Food("韭菜包子", 10),
            new Food("豆沙", 12),
            new Food("咸菜", 13),
            new Food("鲜肉", 14),
            new Food("土豆", 15),
            new Food("包菜", 16),
    };

    public ProducerTask(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        // 不断生成包子
            while (true) {
                try {
                    container.setFood(foods[(int) (Math.random()*foods.length)]);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }



        }

    }
}

// 消费者类
class ConsumerTask implements Runnable {
    Container container;

    public ConsumerTask(Container container) {
        this.container = container;
    }


    @Override
    public void run() {
        // 狂吃包子


            while (true) {
                try {
                    container.eatFood();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }

    }
}

class Container {
    // 定义成员 默认只能放一个
    Food food;

    // 生成包子的方法  ， 只有生成者 执行
    public synchronized boolean setFood(Food newFood) throws InterruptedException {

        // 判断是否有 包子
        if (isEmpty()) {
            food = newFood;
            System.out.println(Thread.currentThread().getName() + "生产者生产包子了： " + food);
            this.notify();
            return true;
        }else {
            this.notify();
            this.wait();
        }
        // 没包子
        return false;
    }

    // 吃包子的方法，只有消费者执行
    public synchronized Food eatFood() throws InterruptedException {
        if (!isEmpty()) {
            Food takeFood = food;
            food = null;
            System.out.println(Thread.currentThread().getName() + "消费者吃了包子：" + takeFood);
            this.notify();
            return takeFood;
        } else {
            this.notify();
            this.wait();
        }
        return null;
    }

    // 判断 蒸笼状态的方法
    public boolean isEmpty() {
        return food == null;
    }

}

class Food {
    String name;
    int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
