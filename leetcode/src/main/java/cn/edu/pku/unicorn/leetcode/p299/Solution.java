/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package cn.edu.pku.unicorn.leetcode.p299;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by v_zhengkun on 2016/2/21.
 * 299. Bulls and Cows
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getHint("1807", "7810"));
        System.out.println(solution.getHint("1123", "0111"));
    }

    public String getHint(String secret, String guess) {
        HashSet<Character> secretSet = new HashSet<Character>();
        HashSet<Character> guessSet = new HashSet<Character>();
        int ACount = 0;
        for (int i = 0; i < secret.length() && i < guess.length(); i++) {
            secretSet.add(secret.charAt(i));
            guessSet.add(guess.charAt(i));
            if (secret.charAt(i) == guess.charAt(i)) {
                ACount++;
            }
        }
        int BCount = 0;
        Iterator<Character> itr = guessSet.iterator();
        while (itr.hasNext()) {
            char c = itr.next();
            if (secretSet.contains(c)) {
                BCount++;
            }
        }
        BCount -= ACount;
        return ACount + "A" + BCount + "B";
    }

    public String getHint1(String secret, String guess) {
        int[] secretCounts = new int[10];
        int[] guessCounts = new int[10];

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            int sInt = s - '0';
            int gInt = g - '0';
            if (sInt == gInt) {
                bulls++;
            } else {
                secretCounts[sInt]++;
                guessCounts[gInt]++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCounts[i], guessCounts[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
