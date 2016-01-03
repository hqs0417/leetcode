package cn.edu.pku.unicorn.leetcode.p015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution {
    /**
     * 先排序
     * 先选定一个值，然后从两侧逼近，找到合适的值保存
     *
     * @param nums
     *
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);//排序

        final int target = 0;//目标值
        int size = nums.length;//数组的长度

        for (int i = 0; i < size - 2; ++i) {//
            int j = i + 1;//左侧位置
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;//相等则跳过
            }

            int k = size - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    ++j;
                    while (nums[j] == nums[j - 1] && j < k) {
                        ++j;
                    }
                } else if (nums[i] + nums[j] + nums[k] > target) {
                    --k;
                    while (nums[k] == nums[k + 1] && j < k) {
                        --k;
                    }
                } else {
                    ArrayList<Integer> triple = new ArrayList<Integer>();
                    triple.add(nums[i]);
                    triple.add(nums[j]);
                    triple.add(nums[k]);
                    result.add(triple);
                    ++j;
                    --k;
                    while (nums[j] == nums[j - 1] && nums[k] == nums[k + 1] && j < k) {
                        ++j;
                    }
                }
            }
        }

        return result;
    }

    /**
     * 再写一遍
     * 加深记忆
     *
     * @param nums
     *
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);//排序
        final int n = nums.length;//数组长度
        final int target = 0;//目标值，根据题目设置为0,
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;//当期处理的值，与上一个元素相等，则跳过，否则会产生重复值
            }
            int remain = target - nums[i];//0减去当前元素的剩下的值
            int left = i + 1, right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] < remain) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (nums[left] + nums[right] > remain) {
                    right--;
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    List<Integer> triple = new ArrayList<Integer>();
                    triple.add(nums[i]);
                    triple.add(nums[left]);
                    triple.add(nums[right]);
                    left++;
                    right--;
                    result.add(triple);
                    while (left < right && nums[left] == nums[left - 1] && nums[right] == nums[right + 1]) {
                        left
                                ++;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum1(nums);
        for (Iterator<List<Integer>> iterator = result.iterator(); iterator.hasNext(); ) {
            List<Integer> list = iterator.next();
            for (Iterator<Integer> iterator2 = list.iterator(); iterator2.hasNext(); ) {
                System.out.print(String.format("%4d ", iterator2.next()));
            }
            System.out.println();
        }

    }
}
