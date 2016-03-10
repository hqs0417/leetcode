package cn.edu.pku.unicorn.leetcode.p278;

/**
 * Created by v_zhengkun on 2016/3/6.
 */
public class Solution extends VersionControl {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(10));
    }

    public int firstBadVersion(int n) {
        int start = 0, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return start;
    }
}

