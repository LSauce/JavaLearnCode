package _02dsdb.day01_generic._02normal;

/**
 * @author kiro
 * @description:
 * @data 14:47 9/11/2023
 **/

/*
**背景条件**

- 汽车类
- 汽车的车库(主要用于存放车)。还提供一个方法获取汽车
 */
public class AutoCarHolder {

    private AutoCar[] autoCars;
    private int count;

    public AutoCarHolder(int length) {
        this.autoCars = new AutoCar[length];
    }

    public boolean addCar(AutoCar autoCar){
        if(count  < autoCars.length){
            autoCars[count++] = autoCar;
            return true;
        }

        return false;
    }

    public AutoCar getCar(int index){
        if(index > 0 && index < count){
            return autoCars[index];
        }

        return null;

    }
}
