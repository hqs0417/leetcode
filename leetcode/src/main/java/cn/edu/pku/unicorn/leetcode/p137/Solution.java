package cn.edu.pku.unicorn.leetcode.p137;

/**
 * Created by v_zhengkun on 2016/3/7.
 * 137 Single Number II
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1, 3, 1, 1};
        System.out.println(solution.singleNumber(nums));
        System.out.println(solution.singleNumber1(nums));
        System.out.println(-2 >> 3); // 
    }

    /**
     * 位操作
     * 创建一个长度为int count[32]的数组
     * 数组
     * 统计每个数字在各个位上出现的次数
     * 如果出现的次数为3则将该位忽略
     *
     * @param nums
     *
     * @return
     */
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += (n >> i) & 1;
                count[i] %= 3;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += (count[i] << i);
        }
        return result;
    }

    /**
     *
     * @return
     */
    public int singleNumber1(int[] nums) {
        int one = 0, two = 0, three = 0;
        for (int i : nums) {
            two |= (one & i);
            System.out.println("two " + Integer.toBinaryString(two));
            one ^= i;
            System.out.println("one " + Integer.toBinaryString(one));
            three = ~(one & two);
            System.out.println("three " + Integer.toBinaryString(three));
            one &= three;
            two &= three;
            System.out.println("one " + Integer.toBinaryString(one));
            System.out.println("two " + Integer.toBinaryString(two));
        }
        return one;
    }
}
