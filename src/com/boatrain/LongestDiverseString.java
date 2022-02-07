package com.boatrain;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-happy-string/
 */
public class LongestDiverseString {
    static class Pair {
        int freq;
        char ch;

        public Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder();
        Pair[] pairs = {new Pair(a, 'a'), new Pair(b, 'b'), new Pair(c, 'c')};
        while (true) {
            Arrays.sort(pairs, (p1, p2) -> p2.freq - p1.freq);
            boolean hasNext = false;
            for (Pair pair : pairs) {
                if (pair.freq == 0) break;
                int len = ans.length();
                if (len >= 2 && ans.charAt(len - 2) == pair.ch && ans.charAt(len - 1) == pair.ch) {
                    continue;
                }
                hasNext = true;
                ans.append(pair.ch);
                pair.freq--;
                break;
            }
            if (!hasNext) break;
        }
        return ans.toString();
    }
}
