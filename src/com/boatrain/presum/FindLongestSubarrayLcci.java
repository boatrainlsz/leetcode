package com.boatrain.presum;

public class FindLongestSubarrayLcci {
    public String[] findLongestSubarray(String[] array) {
        int[] numberPreSum = new int[array.length];
        int[] letterPreSum = new int[array.length];
        numberPreSum[0] = isDigit(array[0]) ? 1 : 0;
        letterPreSum[0] = 1 - numberPreSum[0];
        for (int i = 1; i < array.length; i++) {
            boolean isDigit = isDigit(array[i]);
            numberPreSum[i] = numberPreSum[i - 1];
            letterPreSum[i] = letterPreSum[i - 1];
            if (isDigit) {
                numberPreSum[i]++;
            } else {
                letterPreSum[i]++;
            }
        }
        if (letterPreSum[letterPreSum.length - 1] == letterPreSum.length) {
            return new String[]{};
        }
        if (numberPreSum[numberPreSum.length - 1] == numberPreSum.length) {
            return new String[]{};
        }
        int[] ans = new int[]{-1, -1};
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int numberCount = numberPreSum[j] - (i == 0 ? 0 : numberPreSum[i - 1]);
                int letterCount = letterPreSum[j] - (i == 0 ? 0 : letterPreSum[i - 1]);
                if (numberCount == letterCount) {
                    if (j - i > ans[1] - ans[0]) {
                        ans[1] = j;
                        ans[0] = i;
                    } else if (j - i == ans[1] - ans[0] && i < ans[0]) {
                        ans[1] = j;
                        ans[0] = i;
                    }
                }
            }
        }
        if (ans[0] == -1 && ans[1] == -1) return new String[]{};
        String[] result = new String[ans[1] - ans[0] + 1];
        System.arraycopy(array, ans[0], result, 0, result.length);
        return result;
    }

    private boolean isDigit(String s) {
        return Character.isDigit(s.charAt(0));
    }
}