package cn.edu.pku.unicorn.leetcode.p039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by v_zhengkun on 2016/3/30.
 * 39. Combination Sum I
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 6, 7};
        System.out.println(solution.combinationSum(nums, 7));
        int[] nums1 = {8, 7, 4, 3};
        System.out.println(solution.combinationSum(nums1, 11));
    }

    /**
     * 回溯法，枚举所有情况，剪枝
     *
     * @param candidates candidates
     * @param target     target
     *
     * @return List of numbers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        search(candidates, target, 0, path, result);
        return result;
    }

    /**
     * helper method
     *
     * @param candidates candidates
     * @param target     target num
     * @param pos        start pos of nums, to avoid duplicate search
     * @param path       list of numbers, search path
     * @param result     the result to return
     */
    private void search(int[] candidates, int target, int pos, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path)); // Notice! must alloc a new array
            return;
        }

        for (int i = pos; i < candidates.length && target >= candidates[i]; i++) {
            path.add(candidates[i]);
            search(candidates, target - candidates[i], i, path, result);
            path.remove(path.size() - 1); // remove last
        }
    }
}
