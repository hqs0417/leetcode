package cn.edu.pku.unicorn.leetcode.p204;

/**
 * Created by v_zhengkun on 2016/3/6.
 */
public class Solution {
    public int countPrimes1(int n) {
        int count = 0;
        for (int i = 2; i <=n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @param n
     * @return
     */
    public boolean isPrime(int n ) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * 使用Sieve of Eratosthenes
     *
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}