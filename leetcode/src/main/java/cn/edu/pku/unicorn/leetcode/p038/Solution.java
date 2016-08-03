package cn.edu.pku.unicorn.leetcode.p038;

/**
 * Created by v_zhengkun on 2016/2/21.
 * 38. Count and Say
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(3));
    }
    public String countAndSay(int n) {
        String previous = "1";
        int i = 1;
        while (i < n) {
            previous = count(previous);
            i++;
        }
        return previous;
    }

    public String count(String s) {
        StringBuilder result = new StringBuilder();
        int start = 0, end = 1;
        int count = 1;
        while (end < s.length()) {
            if (s.charAt(end) == s.charAt(start)) {
                count++;
            } else {
                result.append(count);
                result.append(s.charAt(start));
                count = 1;
                start = end;
            }
            end++;
        }
        result.append(count);
        result.append(s.charAt(start));

        return result.toString();
    }
}