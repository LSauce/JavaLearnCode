package cn.kiroe.day01;

public class Main3 {
    public static void main(String[] args) {
        String s = "\\\"Sue,\\\" Tom smiles, \\\"Selim smote us.\\\"";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] cs = s.toCharArray();
        //双指针:
        while (left < right) {
            char lc = cs[left];
            char rc = cs[right];

            //获取左边字母
            while (isLetter(lc)) {
                if(++left >= right){
                    return true;
                }
                lc = cs[left];
            }
            //获取右边字母
            while (isLetter(rc)) {
                if(--right <= left ){
                    return true;
                }
                rc = cs[right];
            }
            if (!ignoreCaseEqual(lc, rc)) {
                return false;
            }

            left++;
            right--;


        }

        return true;
    }

    public static boolean isLetter(char c) {
        return (65 > c || c > 90) && (97 > c || c > 122) && (48 > c || c >57);
    }

    public static boolean ignoreCaseEqual(char c1, char c2) {
        char c3 = (c1 >= 65 && c1 <= 90) ? (char) (c1 + 32) : c1;
        char c4 = (c2 >= 65 && c2 <= 90) ? (char) (c2 + 32) : c2;

        return c3 == c4;
    }


}
