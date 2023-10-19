package cn.kiroe.day04._06operations;

import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 10:23 17/10/2023
 **/
public class _06crud {

    public static void main(String[] args) {
        String[] names = new String[]{"2", "3", "23", "332", "23", "234", null, null};
        System.out.println(Arrays.toString(names));

        int index = createName(names, "彭于晏");
        System.out.println(names[index] + ":" + Arrays.toString(names));


        int i = findName(names, "fff");
        if(i!=-1){
            System.out.println(names[i]);
        }else{
            System.out.println(i);
        }

        updateName(names,"2","change");
        System.out.println(Arrays.toString(names));
        delName(names,"3");
        System.out.println(Arrays.toString(names));


    }
    //改
    private static boolean updateName(String[] names,String value1,String value2){
        if (names!=null && value1 !=null){
            int index  = findName(names,value1);
            if(index>=0){
                names[index] = value2;
                return true;
            }else {
                return false;
            }
        }

        return false;
    }
    //删
    private static boolean delName(String[] names,String value){
        if(names!=null && value != null){
            int index = findName(names,value);
            if(index >=0 ){
                names[index] = null;
                return true;
            }else {
                return false;
            }

        }
        return false;
    }

    private static int findName(String[] names, String value) {
        int result = -1;
        if (names != null && value != null) {
            for (int i = 0; i < names.length; i++) {
                if (value.equals(names[i])) {
                    return i;
                }
            }
        }

        return result;
    }

    public static boolean arrayContains(String[] names, String value) {
        if (names != null && value != null) {
            for (String name : names) {
                //链式调用时 尽量将常量放前面
                if (value.equals(names[0])) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @param names 原数组
     * @param value 新插入的名字
     * @return int 状态值
     * >=0 -->插入成功,返回插入下标
     * -1 --> 数组满了
     * -2 --> 重名
     * -3 --> 其他
     */
    private static int createName(String[] names, String value) {
        //重复的不插入
        int status = -3;
        if (names != null && value != null) {
            if (arrayContains(names, value)) {
                return -2;
            }

            for (int i = 0; i < names.length; i++) {
                if (names[i] == null) {
                    names[i] = value;
                    return i;
                }
            }
            return -1;
        }
        return status;
    }

    // 增

    // 删
    // 改
    // 查
}
