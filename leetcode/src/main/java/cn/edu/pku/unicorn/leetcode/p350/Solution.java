package cn.edu.pku.unicorn.leetcode.p350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by unicorn on 2016/8/2.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 2, 3};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(solution.intersect1(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            Integer n = map.get(i);
            if (n == null) {
                map.put(i, 1);
            } else {
                map.put(i, n + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            Integer n = map.get(i);
            if (n != null && n > 0) {
                map.put(i, n - 1);
                result.add(i);
            }
        }
        int[] arr = new int[result.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    /**
     * Java8 Stream & Lamda
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i : nums1) {
            map.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        for (int i : nums2) {
            map.computeIfPresent(i, (k, v) -> {
                list.add(k);
                v--;
                return v == 0 ? null : v;
            });
        }
        return list.stream().mapToInt(i->i).toArray();
    }


}
