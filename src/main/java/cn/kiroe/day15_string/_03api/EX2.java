package cn.kiroe.day15_string._03api;

/**
 * @author kiro
 * @description:
 * @data 11:50 30/10/2023
 **/
public class EX2 {
    /*

    课堂练习：
	1：遍历获取字符串中的每一个字符
	"abc001DEF"
	2：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。(不考虑其他字符)
     */
    public static void main(String[] args) {
        String source = "abc001DEF";
        int UpCaseCount = 0;
        int lowerCaseCount = 0;
        int digtilCount = 0;

        for (char c : source.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                UpCaseCount++;
            } else if (c >= 'a' && c <= 'z') {
                lowerCaseCount++;
            } else if (c >= '0' && c <= '9') {
                digtilCount++;
            }
        }

        System.out.println("UpcaseCount = " + UpCaseCount);
        System.out.println("lowercaseCount = " + lowerCaseCount);
        System.out.println("numberCount = " + digtilCount);

        //方法二：
        for (char c : source.toCharArray()) {
            if (Character.isUpperCase(c)) {
                UpCaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            } else if (Character.isDigit(c)) {
                digtilCount++;
            }
        }
    }
}
