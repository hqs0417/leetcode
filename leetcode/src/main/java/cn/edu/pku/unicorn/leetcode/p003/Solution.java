package cn.edu.pku.unicorn.leetcode.p003;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0;
        int maxLength = 1;
        Set<Character> set = new HashSet<Character>();//set为当前存储的不重复子序列
        set.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            //检测s[i]是否在set中
            //如果不在则加入，end++

            //如果在将s[end]从set中取出
            //再次进行判断

            //注意set元素个数为0的情况
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(start++));
            }
            set.add(s.charAt(i));

            maxLength = (set.size() > maxLength) ? set.size() : maxLength;

        }
        return maxLength;
    }
}
