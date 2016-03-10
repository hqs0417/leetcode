package cn.edu.pku.unicorn.leetcode.p238;

import java.util.Arrays;

/**
 * Created by v_zhengkun on 2016/3/10.
 * 238 Product Except Self
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] output = solution.productExceptSelf2(nums);
        System.out.println(Arrays.toString(output));

    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];
        int[] arr1 = new int[nums.length];
        arr1[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            arr1[i] = arr1[i - 1] * nums[i - 1];
        }
        int[] arr2 = new int[nums.length];
        arr2[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            arr2[i] = arr2[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = arr1[i] * arr2[i];
        }
        return output;
    }

    /**
     * 根据第一种优化
     * 使用常量保存计算结果
     * @return
     */
    public int[] productExceptSelf1(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        System.out.println(Arrays.toString(output));
        int t = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            t *= nums[i + 1];
            output[i] *= t;
        }
        System.out.println(Arrays.toString(output));
        return output;
    }

    /**
     * 递归计算
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        multiply(nums, 1, 0, nums.length);
        return nums;
    }

    /**
     *
     * @param a
     * @param fwdProduct 乘积
     * @param index 当前计算的下标
     * @param N 总数
     * @return
     */
    private int multiply(int[] a, int fwdProduct, int index, int N) {
        int revProduct = 1;
        if (index < N) {
            revProduct = multiply(a, fwdProduct * a[index], index + 1, N);
            int cur = a[index];
            a[index] = fwdProduct * revProduct;
            revProduct *= cur;
        }
        return revProduct;
    }
}
