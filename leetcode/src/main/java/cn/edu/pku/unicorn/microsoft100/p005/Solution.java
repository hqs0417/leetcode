package cn.edu.pku.unicorn.microsoft100.p005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 查找最小的k个元素
 * 例如输入1，2，3，4，5，6，7 和8 这8 个数字，则最小的4 个数字为1，2，3 和4
 * Created by v_zhengkun on 2016/8/10.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 2, 6, 1, 3, 5, 7};
        System.out.println(solution.findMinimalKElements(nums, 4));
    }

    /**
     * 用最小堆实现
     * 由于PriorityQueue是大根堆，这里自定义MyInt，反转排序方式
     *
     * @param nums
     *
     * @return
     */
    public List<Integer> findMinimalKElements(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<MyInt> heap = new PriorityQueue<>();
        for (int x : nums) {
            heap.offer(new MyInt(x));
            if (heap.size() > k) {
                heap.poll();
            }
        }
        while (!heap.isEmpty()) {
            list.add(heap.poll().x);
        }
        return list;
    }

    private static class MyInt implements Comparable<MyInt> {
        private int x;

        public MyInt(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(MyInt o) {
            return o.x - x;
        }
    }


}
