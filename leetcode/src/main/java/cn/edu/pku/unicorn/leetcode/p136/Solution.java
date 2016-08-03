package cn.edu.pku.unicorn.leetcode.p136;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by v_zhengkun on 2016/3/7.
 * 136 Single Number
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1, 2, 1, 2, 3, 4, 5, 4, 5};
        System.out.println(solution.singleNumber(nums));
        System.out.println(solution.singleNumber1(nums));
    }

    /**
     * 使用hash table
     * 时间复杂度是O(n)
     * 空间复杂度是O(1)
     *
     * @param nums
     *
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, 2);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 使用位操作
     * 异或
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        int x = 0;
        for (int i : nums) {
            x ^= i;
        }
        return x;
    }

}
