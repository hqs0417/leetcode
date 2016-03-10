package cn.edu.pku.unicorn.leetcode.p168;

/**
 * Created by v_zhengkun on 2016/3/6.
 * 168 Excel Sheet Column Title
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        for (int i = 1; i < 100; i++) {
//            System.out.println(i + "=>" + solution.convertToTitle1(i));
//        }
        System.out.println(solution.convertToTitle1(27));
    }

    /**
     * recursive
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        return convertToTitle((n - 1) / 26) + (char)((n - 1) % 26 + 'A');
    }

    /**
     * non recursive
     * @param n
     * @return
     */
    public String convertToTitle1(int n ) {
        if (n == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char)((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return sb.toString();
    }

}
