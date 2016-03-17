package cn.edu.pku.unicorn.leetcode.p096;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by v_zhengkun on 2016/3/14.
 * 96. Unique Binary Search Trees
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        for (int i = 2; i < 1000; i ++) {
            solution.numTrees(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        start = end;

        for (int i = 2; i < 1000; i++) {
            solution.numTrees1(i);
        }

        end = System.currentTimeMillis();
        System.out.println(end - start);
        // System.out.println(solution.numTrees(4));
    }

    public int numTrees(int n) {
        int[] treeSizeArr = new int[n + 1];
        treeSizeArr[1] = 1;
        for(int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int left = 1;
                int right = 1;
                if (j > 1) {
                    left = treeSizeArr[j - 1];
                }
                if (i > j) {
                    right = treeSizeArr[i - j];
                }
                treeSizeArr[i] += left * right;
            }
        }
        return treeSizeArr[n];
    }
    private Map<Integer, Integer> treeSizeMap = new HashMap<>();
    {
        treeSizeMap.put(1, 1);
    }
    public int numTrees1(int n) {
        // 如果存在，则直接返回
        if (treeSizeMap.get(n) != null) {
            return treeSizeMap.get(n);
        }
        treeSizeMap.put(n, 0);
        for (int i = 1; i <= n; i++) {
            int left = 1;
            int right = 1;
            if (i > 1) {
                if (treeSizeMap.get(i - 1) != null) {
                    left = treeSizeMap.get(i - 1);
                } else {
                    left = numTrees1(i - 1);
                }
            }
            if (n > i) {
                if (treeSizeMap.get(n - i) != null) {
                    right = treeSizeMap.get(n - i);
                } else {
                    right = numTrees1(n - i);
                }
            }
            treeSizeMap.put(n, left * right + treeSizeMap.get(n));
        }
        return treeSizeMap.get(n);
    }
}
