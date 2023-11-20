package cn.kiroe.day16_file.homework.ex2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author kiro
 * @description:
 * @data 19:20 31/10/2023
 **/

/*

(选做)创建一个长度是100的字符串数组
使用长度是2的随机字符填充该字符串数组 统计这个字符串数组里重复的字符串有多少种(忽略大小写)

例如 输出: 20个字符串一行 共5行
 01 0S 1M 1q 20 2R 2S 3d 3k 3x 43 4A 4R 5T 7C 7U 7e 7k 80 88 8p AD AG AY BF BO Db E2 Eg El GF Gm HC HO IB If J0 JY Jv KW L0 LT MA NL NL NU PY Qx Rr Ry SB So TH Tu UR VD WR Xe Xw Xx Y3 YL Yd Yk a3 aL bW bq cI cv cv dg eL fL gA gL gh h4 hm j7 jp kN m1 mS o6 pQ qV rP rf s7 sA um vE vP vb w6 wB xP yK yQ

El发生了重复 重复了2次

NL发生了重复 重复了2次

Yk发生了重复 重复了2次

cv发生了重复 重复了2次
 */
public class StringEX1 {

    public static void main(String[] args) {
        // 创建一个长度是100的字符串数组
        String[] strings = new String[100];
        // 使用长度是2的随机字符填充该字符串数组 统计这个字符串数组里重复的字符串有多少种(忽略大小写)
        for (int i = 0; i < strings.length; i++) {
            strings[i] = getRandomTwoLengthString();
        }
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(strings).forEach((s) -> {
            // 遍历后添加进 map
            map.put(s.toLowerCase(), map.getOrDefault(s.toLowerCase(), 0)+1);
        });

        // 获取便利字符
        System.out.println("map.entrySet().stream().filter((e)-> e.getValue() > 1) = " + Arrays.toString(map.entrySet().stream().filter((e) -> e.getValue() > 1).toArray()));
    }

    public static String getRandomTwoLengthString() {
        return String.valueOf(getRandomCharFromPoll()) + getRandomCharFromPoll();
    }

    public static char getRandomCharFromPoll() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = '0'; i <= '9'; i++) {
            stringBuilder.append((char) i);
        }

        for (int i = 'a'; i < 'z'; i++) {
            stringBuilder.append((char) i);
        }

        for (int i = 'A'; i < 'Z'; i++) {
            stringBuilder.append((char) i);
        }

        return stringBuilder.charAt(random.nextInt(stringBuilder.length()));
    }
}
