package _02dsdb.day04_list_queue.homework.listwork;

import java.util.ArrayList;

/**
 * @author kiro
 * @description:
 * @data 19:46 13/11/2023
 **/
public class ArrayListWork3 {
    public static void main(String[] args) {
        /*
                [选做] 尝试阅读ArrayList源码。并描述过程
        创建   add()
            默认大小为10，可设置初始容量，
        添加
            add(Object o): 添加至尾部，添加时判断容量，使用grow扩容，每次变为 1.5倍
            add(int index) : 添加至index处，先判断是否扩容，再将后部整体向后移动，使用System.arrayCopy() native增加效率
        删除
            remove(int index):  判断下标是否合格，将index后部分向前移动，尾部赋值为 null
            remove(Object o):  查找到 第一个equal的o,调用fastRemove(int index)
        查询
            indexOf(Object o): 顺序查找 返回第一个 符合值，未找到返回 nul
            lastIndexOf(Object 0):  从尾部开始找，同上

         */

        ArrayList<Integer> integers = new ArrayList<>();
        integers.remove(new Integer(12));
        integers.indexOf(10);

    }
}
