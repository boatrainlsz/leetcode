package com.boatrain.numbers;

/**
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        MonotoneIncreasingDigits solution = new MonotoneIncreasingDigits();
        System.out.println(solution.monotoneIncreasingDigits(5486));
    }

    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int index = chars.length;
        for (int i = chars.length - 1; i > 0; i--) {
            if ((int) chars[i - 1] > (int) chars[i]) {
                index = i;
                chars[i - 1]--;
                chars[i] = '9';
            }
        }
        for (int i = index; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }
}