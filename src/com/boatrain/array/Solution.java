package com.boatrain.array;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfMatches(14));
    }

    public int numberOfMatches(int n) {
        int result = 0;
        int cur = n;
        while (true) {
            int match = 0;
            if (cur % 2 == 0) {
                //偶数
                cur /= 2;
                match += cur;
            } else {
                //jishu
                cur = (cur - 1) / 2 + 1;
                match += cur - 1;
            }
            result += match;
            if (match == 1) {
                break;
            }
        }
        return result;
    }
}