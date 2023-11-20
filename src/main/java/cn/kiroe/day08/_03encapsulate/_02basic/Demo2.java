package cn.kiroe.day08._03encapsulate._02basic;

/**
 * @author kiro
 * @description:
 * @data 15:31 20/10/2023
 **/
/*

    private boolean gender;// 布尔类型 成员变量名 不要叫 isXxx

 */
public class Demo2 {
}

class Teacher{
    String name;
    private boolean gender;// 布尔类型 成员变量名 不要叫 isXxx

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    /*
    private boolean isMale;//

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
    */

}
