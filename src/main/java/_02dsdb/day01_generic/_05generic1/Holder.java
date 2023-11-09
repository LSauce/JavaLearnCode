package _02dsdb.day01_generic._05generic1;

/**
 * @author kiro
 * @description:
 * @data 15:22 9/11/2023
 **/
/*

泛型： 用一个不存在的类型 来代替类型
<T> 中的T可 随意改变，符合 标识符命名即可
但一般是 T : Type, E : Element ,V: Value

 */

public class Holder<T> {

    private T data;

    public Holder(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
