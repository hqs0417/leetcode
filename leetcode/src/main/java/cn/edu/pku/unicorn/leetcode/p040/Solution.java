package cn.edu.pku.unicorn.leetcode.p040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by v_zhengkun on 2016/3/30.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 1, 2, 7, 1, 6, 5};
        System.out.println(solution.combinationSum2(nums, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return result;
        }
        Arrays.sort(candidates); // 排序
        List<Integer> path = new ArrayList<>();
        search(candidates, target, 0, path, result);

        // 消除result中的重复列表
        return result;
    }

    private void search(int[] candidates, int target, int pos, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || pos >= candidates.length) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (i > pos && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            search(candidates, target - candidates[i], i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}