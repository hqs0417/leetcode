package cn.edu.pku.unicorn.leetcode.p347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author v_zhengkun
 * @since 2016/5/7 16:27
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            Integer count = map.get(n);
            if (count == null) {
                map.put(n, 1);
            } else {
                map.put(n, count + 1);
            }
        }
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.add(new Pair(entry.getKey(), entry.getValue()));
        }

        List<Integer> list = new ArrayList<>();
        while (k-- > 0) {
            list.add(q.poll().i);
        }
         return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3};
        System.out.println(solution.topKFrequent(nums, 2));
    }

    private static class Pair implements Comparable {
        int i;
        int count;
        Pair(int i, int count) {
            this.i = i;
            this.count = count;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair pair = (Pair) o;

            if (i != pair.i) {
                return false;
            }
            return count == pair.count;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + count;
            return result;
        }

        @Override
        public int compareTo(Object o) {
            Pair other = (Pair) o;
            if (other.count == count) {
                return 0;
            } else if (other.count > count) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
