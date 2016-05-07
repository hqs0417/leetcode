package cn.edu.pku.unicorn.leetcode.p077;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v_zhengkun on 2016/4/8.
 * 77. Combination
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2));
    }
    /**
     * 回溯法C(n,k)
     * @param n n
     * @param k N
     * @return all combinations
     */
    public List<List<Integer>> combine(int n ,int k) {
        List<List<Integer>> result = new ArrayList<>();
        DFS(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    public void DFS(List<List<Integer>> result, List<Integer> path, int n, int k, int level ) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (path.size() > k) {
            return;
        }
        for (int i = level; i <= n; i++) {
            path.add(i);
            DFS(result, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
