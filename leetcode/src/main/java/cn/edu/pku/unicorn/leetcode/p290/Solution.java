/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package cn.edu.pku.unicorn.leetcode.p290;

import java.util.HashMap;

/**
 * Created by v_zhengkun on 2016/2/21.
 * 290. Word Pattern
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("aaa", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
    }
    public boolean wordPattern(String pattern, String str) {

        if (pattern == null || pattern.length() == 0) {
            if (str == null || str.split(" ").length == 0) {
                return true;
            }
        }

        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> map1 = new HashMap<Character, String>();

        for (int i = 0; i < pattern.length(); i++) {
            if (map1.get(pattern.charAt(i)) == null) {
                map1.put(pattern.charAt(i), words[i]);
            } else {
                if (!map1.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            }
        }

        HashMap<String, Character> map2 = new HashMap<String, Character>();
        for (int i = 0; i < words.length; i++) {
            if (map2.get(words[i]) == null) {
                map2.put(words[i], pattern.charAt(i));
            } else {
                if (!(map2.get(words[i]) == pattern.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}