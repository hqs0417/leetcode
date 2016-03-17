package cn.edu.pku.unicorn.leetcode.p318;

/**
 * Created by v_zhengkun on 2016/3/12.
 * 318. Maximum Product of Word Lengths
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        String[] words1 = new String[] {"ab", "ac", "cd"};
        System.out.println(solution.maxProduct(words));
        System.out.println(solution.maxProduct(words1));
    }

    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }
        int[] orArr = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                orArr[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((orArr[i] & orArr[j]) == 0) {
                    maxProduct = Math.max(words[i].length() * words[j].length(), maxProduct);
                }
            }
        }
        return maxProduct;
    }
}