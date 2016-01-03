package cn.edu.pku.unicorn.leetcode.p006;

public class Solution {
    public static String convert(String s, int nRows) {
        if (nRows == 1) {//特殊情况
            return s;
        }
        char[] charArr = new char[s.length()];
        int count = 0;//index
        for (int i = 0; i < nRows; i++) {//行数
            for (int j = i; j < s.length(); j += nRows * 2 - 2) {//没列之间的间距递增为nRows * 2 - 2
                charArr[count++] = s.charAt(j);
                if (i > 0 && i < nRows - 1) {//中间行需要特殊处理
                    int t = (nRows - 1) * 2;
                    int t1 = ((j / t) * 2 + 1) * t - j;
                    if (t1 < s.length()) {
                        charArr[count++] = s.charAt(t1);
                    }
                }

            }
        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";// 3  PAHNAPLSIIGYIR
        String s1 = "ABC";//2 ACB
        String s2 = "ABCDE"; // 4 AEBCD
        String s3 = "ABCDEF";// 4
        System.out.println(convert(s, 3));
        Integer.parseInt(s3);
    }
}
