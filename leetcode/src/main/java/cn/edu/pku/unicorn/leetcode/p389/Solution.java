package cn.edu.pku.unicorn.leetcode.p389;

/**
 * Created by v_zhengkun on 2016/9/10.
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int[] letters = new int[26];
        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 0) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }


    public char findTheDifference1(String s, String t) {
        int sum = 0;
        for (int i = 0; i < t.length(); i++) {
            sum += t.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            sum -= s.charAt(i);
        }
        return (char) sum;
    }


    public char findTheDifference2(String s, String t) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            sum ^= t.charAt(i);
        }
        return (char) sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcd";
        String t = "abcde";
        System.out.println(solution.findTheDifference(s, t));
        System.out.println(solution.findTheDifference1(s, t));
        System.out.println(solution.findTheDifference2(s, t));
    }
}