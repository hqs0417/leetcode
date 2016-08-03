package cn.edu.pku.unicorn.leetcode.p374;

/**
 * Created by v_zhengkun on 2016/8/3.
 */
public class Solution {

    private int num;

    public Solution(int n) {
        this.num = n;
    }

    private int guess(int i) {
        if (i > num) {
            return -1;
        } else if (i < num) {
            return 1;
        }
        return 0;
    }

    /**
     * @param n max num
     *
     * @return correct num
     */
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);
            if (result == 0) {
                return mid;
            } else if (result == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(6);
        System.out.println(solution.guessNumber(10));
    }
}
