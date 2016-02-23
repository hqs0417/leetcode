package cn.edu.pku.unicorn.leetcode.p190;

/**
 * Created by v_zhengkun on 2016/1/13.
 * 190. Reverse Bits
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int j = 0, result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                j += 1;
            result = j;
            j <<= 1;//31 times
            n >>= 1;//right one bit
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 43261596;
        System.out.println(Integer.toBinaryString(n));
        int r = solution.reverseBits(n);
        System.out.println(Integer.toBinaryString(r));
    }
}