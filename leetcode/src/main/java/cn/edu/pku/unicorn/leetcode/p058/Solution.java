/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package cn.edu.pku.unicorn.leetcode.p058;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v_zhengkun on 2016/2/21.
 * 58. Length of Last Word
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = null;
        System.out.println(solution.lengthOfLastWord1(s));
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
        }
        return s.length() - i - 1;
    }

    public int lengthOfLastWord1(String s) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(s);
        String findStr = "";
        while (matcher.find()) {
            findStr = matcher.group();
        }
        return findStr.length();
    }
}