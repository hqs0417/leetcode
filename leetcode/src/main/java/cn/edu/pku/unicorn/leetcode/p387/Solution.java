package cn.edu.pku.unicorn.leetcode.p387;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by v_zhengkun on 2016/9/10.
 */
public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> indexes = map.get(s.charAt(i));
            if (indexes == null) {
                indexes = new ArrayList<>();
                indexes.add(i);
                map.put(s.charAt(i), indexes);
            } else {
                indexes.add(i);
            }
        }

        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                return entry.getValue().get(0);
            }
        }
        return -1;
    }

    /**
     *
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
