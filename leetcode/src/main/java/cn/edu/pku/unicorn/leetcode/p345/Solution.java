package cn.edu.pku.unicorn.leetcode.p345;

import java.util.HashSet;

/**
 * @author v_zhengkun
 * @since 2016/5/7 16:58
 */
public class Solution {
    private static HashSet<Character> vowelsSet = new HashSet<>();

    static {
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('u');
        vowelsSet.add('A');
        vowelsSet.add('E');
        vowelsSet.add('I');
        vowelsSet.add('O');
        vowelsSet.add('U');
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            while (!isVowel(arr[i]) && i < j) {
                i++;
            }
            while (!isVowel(arr[j]) && i < j) {
                j--;
            }
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
        return new String(arr);
    }

    public boolean isVowel(char c) {
        return vowelsSet.contains(c);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reverseVowels("leetcode"));
    }
}
