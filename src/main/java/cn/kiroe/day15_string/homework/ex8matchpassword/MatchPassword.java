package cn.kiroe.day15_string.homework.ex8matchpassword;

/**
 * @author kiro
 * @description:
 * @data 20:11 30/10/2023
 **/
/*

(选做)穷举匹配密码

第一步，生成一个长度是3的随机数字字符串，把这个字符串数字当做密码。

注：这里生成的随机密码是一个固定三位的数字字符串，如果生成的数字不到3位，需要在前面补0，比如生成的密码是10，密码的字符串为010

然后使用穷举法生成长度是3的字符串(000,001,002...999)，匹配上述生成的密码,将列举到的可能的密码打印,直到匹配成功结束破解过程。
 */
public class MatchPassword {

    /*
    使用 常量pool获取 随机 验证码
     */
    public static Character getCharFromPool(int index) {

        if (index < 0) {
            return null;
        }
        char[] cs = "0123456789".toCharArray();

        return cs[index % cs.length];
    }

    public static void main(String[] args) {
        // 如果生成的数字不到3位，需要在前面补0
        StringBuilder sourceSB = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sourceSB.append(getCharFromPool(((int) (Math.random() * 10))));
        }
        String randomPassword = sourceSB.toString();
        StringBuilder sb = new StringBuilder();
        Label:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    sb.append(i).append(j).append(k);
                    System.out.println("猜的密码为：" + sb);
                    if (randomPassword.endsWith(sb.toString())) {
                        System.out.println("找到密码： " + sb);
                        break Label;
                    }
                    sb.delete(0, sb.length());
                }
            }

        }


    }

}
