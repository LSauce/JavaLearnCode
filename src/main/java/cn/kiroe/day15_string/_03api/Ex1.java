package cn.kiroe.day15_string._03api;

/**
 * @author kiro
 * @description:
 * @data 11:38 30/10/2023
 **/


/*
课堂练习：

 	1. 统计”abc”在字符中”abcdabcfgh”出现的次数
	2. 借助于int indexOf(String str,int fromIndex)
 */
public class Ex1 {
    public static void main(String[] args) {
        // 定义字符串
        String s = "abcdabcfgh";
        String match = "abc";
        System.out.println(s.indexOf(match));
        // 定义计数器
        int count = 0;
        // 定义索引值
        int fromIndex = 0;

        // 循环
        while ((fromIndex = s.indexOf("abc", fromIndex)) != -1) {
            // 计数器 索引值+1
            count++;
            fromIndex++;
        }

        // 循环结束 统计结束 打印
        System.out.println("出现了" + count + "次");
    }
}

