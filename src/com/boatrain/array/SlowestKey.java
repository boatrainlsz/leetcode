package com.boatrain.array;

/**
 * https://leetcode-cn.com/problems/slowest-key/
 */
public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] keys = keysPressed.toCharArray();
        char ans = keys[0];
        int time = releaseTimes[0];
        for (int i = 1; i < keysPressed.length(); i++) {
            int cost = releaseTimes[i] - releaseTimes[i - 1];
            if (cost > time) {
                ans = keys[i];
                time = cost;
            } else if (cost == time) {
                ans = ans > keys[i] ? ans : keys[i];
            }
        }
        return ans;
    }
}
