package cn.edu.pku.unicorn.leetcode.p260;

/**
 * Created by v_zhengkun on 2016/3/9.
 * 260 Single Number III
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int xorResult = 0;
        for (int n : nums) {
            xorResult ^= n;
        }
        int firstOneIndex = 0;
        while (firstOneIndex < 32) {
            if ((xorResult >> firstOneIndex & 1) == 1) {
                break;
            }
            firstOneIndex++;
        }


        int xorResult1 = 0;
        for (int n : nums) {
            if ((n >> firstOneIndex & 1) == 1) {
                xorResult1 ^= n;
            }
        }

        result[0] = xorResult1;
        result[1] = xorResult ^ xorResult1;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 1, 2};
        int[] result = solution.singleNumber(nums);
        System.out.println(result[0] + " " + result[1]);
    }
}
