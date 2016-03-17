package cn.edu.pku.unicorn.leetcode.kmp;

/**
 * Created by v_zhengkun on 2016/3/6.
 * KMP 字符串匹配算法
 * http://blog.csdn.net/v_july_v/article/details/7041827
 */
public class Solution {

    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABD";
        int index = violentMatch1(s, p);
        System.out.println(index);
        System.out.println(s.indexOf(p));
        System.out.println(kmp(s, p));
    }

    /**
     * 暴力匹配 时间复杂度
     * @param s
     * @param p
     * @return
     */
    public static int violentMatch(String s, String p) {
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == p.length()) {
            return i - j;
        }
        return -1;
    }

    public static int violentMatch1(String s, String p) {
        int i = 0;
        for (; i < s.length(); i++) {
            int j = 0;
            for (; j < p.length(); j++) {
                if (s.charAt(i + j) == p.charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            if (j == p.length() + 1) {
                return i;
            } else {
                continue;
            }
        }
        return -1;
    }

    public static int kmp(String s, String p) {
        int[] next = next(p);
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == p.length()) {
            return i - j;
        } else return -1;
    }


    public static int[] next(String p) {
        int[] next = new int[p.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < p.length() - 1) {
            if (k == -1 || p.charAt(k) == p.charAt(j)) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }


}
