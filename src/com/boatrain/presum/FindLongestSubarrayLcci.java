package com.boatrain.presum;

import java.util.Arrays;
import java.util.HashMap;

public class FindLongestSubarrayLcci {
    public static void main(String[] args) {
        FindLongestSubarrayLcci solution = new FindLongestSubarrayLcci();
        System.out.println(Arrays.toString(solution.findLongestSubarray(new String[]{"A", "A", "1"})));
    }

    public String[] findLongestSubarray(String[] array) {
        int[] numberPreSum = new int[array.length + 1];
        int[] letterPreSum = new int[array.length + 1];
        for (int i = 1; i < array.length + 1; i++) {
            boolean isDigit = isDigit(array[i - 1]);
            numberPreSum[i] = numberPreSum[i - 1];
            letterPreSum[i] = letterPreSum[i - 1];
            if (isDigit) {
                numberPreSum[i]++;
            } else {
                letterPreSum[i]++;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = letterPreSum.length - 1; i >= 0; i--) {
            map.put(letterPreSum[i] - numberPreSum[i], i);
        }
        int length = -1;
        int left = Integer.MAX_VALUE;
        for (int i = letterPreSum.length - 1; i >= 0; i--) {
            Integer index = map.get(letterPreSum[i] - numberPreSum[i]);
            if (i - index >= length) {
                length = i - index;
                left = index;
            }
        }
        if (length == -1) return new String[]{};
        String[] ans = new String[length];
        System.arraycopy(array, left, ans, 0, length);
        return ans;
    }

    private boolean isDigit(String s) {
        return Character.isDigit(s.charAt(0));
    }
}