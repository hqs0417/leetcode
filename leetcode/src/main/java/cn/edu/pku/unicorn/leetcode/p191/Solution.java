package cn.edu.pku.unicorn.leetcode.p191;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        long m = n;
        if (n < 0) {
            m &= 0x7fffffff;
            m |= 0x80000000;
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
