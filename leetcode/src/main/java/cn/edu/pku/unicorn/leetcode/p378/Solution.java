package cn.edu.pku.unicorn.leetcode.p378;

import java.util.PriorityQueue;

/**
 * 参考https://www.hrwhisper.me/leetcode-kth-smallest-element-sorted-matrix
 * Created by v_zhengkun on 2016/8/3.
 */
public class Solution {
    /**
     * 使用最小堆，PriorityQueue
     * 堆中剩余n - k + 1个元素，堆顶就是要求的元素
     *
     * @param matrix
     * @param k
     *
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        // 最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int n = matrix.length;
        for (int[] row : matrix) {
            for (int i : row) {
                heap.offer(i);
                if (heap.size() > (n - k + 1)) {
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }

    /**
     * 二分法
     *
     * @param matrix
     * @param k
     *
     * @return
     */
    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int L = matrix[0][0], R = matrix[n - 1][n - 1];
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            int temp = search_lower_than_mid(matrix, n, mid);
            if (temp < k) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return L;
    }

    private int search_lower_than_mid(int[][] matrix, int n, int x) {
        int i = n - 1, j = 0, cnt = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= x) {
                j++;
                cnt += i + 1;
            } else {
                i--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(solution.kthSmallest1(matrix, 8));
    }
}
