package _02dsdb.day04_list_queue.homework.listwork;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kiro
 * @description:
 * @data 19:32 13/11/2023
 **/
/*
假设有一个字符串"abcqweracb"
在不改变前后顺序的前提下去除重复的字符得到
"abcqwer"(结合使用ArrayList)



 */
public class ArrayListWork1 {

    public static void main(String[] args) {

        String source = "abcqweracb";
        String target = removeDuplicateCharacter(source);
        System.out.println("target = " + target);
    }
    public static String  removeDuplicateCharacter(String source){
        if (source == null){
            return null;
        }
        // 使用 hashSet
        Set<Character> set = new HashSet<>();
        // 添加数据
        StringBuilder sb = new StringBuilder();
        // 去重
        for (char c : source.toCharArray()) {
            if(!set.contains(c)){
                set.add(c);
                sb.append(c);
            }
        }

        return sb.toString();
    }

}


