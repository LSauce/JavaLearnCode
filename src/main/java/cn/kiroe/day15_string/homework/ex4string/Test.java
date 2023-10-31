package cn.kiroe.day15_string.homework.ex4string;

/**
 * @author kiro
 * @description:
 * @data 19:26 30/10/2023
 **/
/*
"peter piper picked a peck of pickled peppers"

统计这段绕口令有多少个以p开头的单词

提示:借助split(" ")方法分隔成字符串数组 , startsWith("p")判断是否是p开头
 */
public class Test {

    public static void main(String[] args) {
        String sourceString = "peter piper picked a peck of pickled peppers";
        System.out.println("countStartPWorld(sourceString) = " + countStartPWorld(sourceString));
        System.out.println("countStartPWorld(\" p p p p p p p p p aaf fppppfasdfppdfpasdfpp p fpasdpfp pfd\") = " + countStartPWorld("p p p p p p p p p aaf fppppfasdfppdfpasdfpp p fpasdpfp pfd"));

    }

    public static int countStartPWorld(String string) {
        int count = string.startsWith("p") ? 1 : 0; // 判断 首部
        count += string.split(" p").length - 1;  //获取后面部分 个数,如果开头为 " p"  则0位为 ""
        return count;

    }

}
