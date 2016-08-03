package cn.edu.pku.unicorn.leetcode.p028;

/**
 * Created by v_zhengkun on 2016/3/6.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null ||needle == null) {
            return -1;
        }
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.strStr("ABCD", "CD");
        System.out.println(i);
        System.out.println("".indexOf(""));
    }

}
