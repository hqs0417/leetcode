package cn.edu.pku.unicorn.leetcode.p010;

/**
 * Regular Expression Matching
 * 两种解法，分治法和有限状态机
 *
 * @author Unicorn
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aab", "c*a*b"));
    }

    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }

}
