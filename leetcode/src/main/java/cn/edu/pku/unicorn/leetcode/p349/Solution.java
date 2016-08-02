package cn.edu.pku.unicorn.leetcode.p349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author v_zhengkun
 * @since 2016/5/21 9:10
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int j : nums2) {
            set2.add(j);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int i = 0;
        for (int t : set1) {
            result[i++] = t;
        }
        return result;
    }

    /**
     * 使用Java8 stream
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1).distinct().filter(set::contains).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersection(nums1, nums2)));
        System.out.println(Arrays.toString(solution.intersection1(nums1, nums2)));
    }
}
