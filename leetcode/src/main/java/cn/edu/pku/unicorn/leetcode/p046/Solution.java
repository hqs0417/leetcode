package cn.edu.pku.unicorn.leetcode.p046;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v_zhengkun on 2016/3/30.
 * 046. Permutation 全排列
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution.permute(nums));
    }

    /**
     * 递归算法
     * 每次取出一个，剩下的全排列
     *
     * @param nums
     *
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        return helper(list);
    }

    /**
     * @return
     */
    public List<List<Integer>> helper(List<Integer> nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.isEmpty()) {
            return result;
        }
        // 只有一个元素
        if (nums.size() == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums.get(0));
            result.add(list);
        }
        // 循环序列，每次取出一个元素，作为开头的元素，剩下的元素全排列
        for (int i = 0; i < nums.size(); i++) {
            // 剩下的元素
            List<Integer> left = new ArrayList<>();
            for (int j = 0; j < nums.size(); j++) {
                if (j != i) {
                    left.add(nums.get(j));
                }
            }
            // 对剩下的元素全排列
            List<List<Integer>> subResult = helper(left);
            // 将结果列表头部添加上面的元素
            for (List<Integer> l : subResult) {
                l.add(0, nums.get(i));
                result.add(l);
            }
        }
        return result;
    }

}
