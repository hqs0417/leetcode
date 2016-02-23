package cn.edu.pku.unicorn.leetcode.p172;


public class Solution {
    /**
     * 时间复复杂度为O(n)
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int trailingZeros = 0;
        int t;
        for (int i = 5; i <=n; i += 5) {
            t = i;
            while (t >= 5) {
                trailingZeros++;
                t /= 5;
            }
        }
        return trailingZeros;
    }

    /**
     * O(log(n))
     * @return
     */
    public int trailingZeros1(int n ) {
        if (n < 5) {
            return 0;
        }
        return n / 5 + trailingZeros1(n / 5);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 100; i ++) {
            System.out.println(i + ":" + solution.trailingZeroes(i));
        }
    }
}
