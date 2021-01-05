package com.boatrain.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/positions-of-large-groups/
 */
public class PositionsOfLargeGroups {
    public static void main(String[] args) {
        PositionsOfLargeGroups solution = new PositionsOfLargeGroups();
        System.out.println(solution.largeGroupPositions("abbxxxxzyyxxxyybb"));
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        if (s == null || "".equals(s)) return null;
        List<List<Integer>> ans = new ArrayList<>();
        //abbxxxxzyyxxyybb
        //前后都加一个特殊符号，使循环代码更简洁
        s = "|" + s + '|';
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        Arrays.fill(lastIndex, -1);
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 1; i < n - 1; i++) {
            int alphabetIndex = chars[i] - 'a';
            if (chars[i] != chars[i - 1]) {
                firstIndex[alphabetIndex] = i - 1;
            }
            if (chars[i + 1] != chars[i]) {
                lastIndex[alphabetIndex] = i - 1;
            }
            if (firstIndex[alphabetIndex] != -1 && lastIndex[alphabetIndex] != -1
                    && lastIndex[alphabetIndex] - firstIndex[alphabetIndex] >= 2) {
                List<Integer> temp = new ArrayList<>();
                temp.add(firstIndex[alphabetIndex]);
                temp.add(lastIndex[alphabetIndex]);
                ans.add(temp);
            }
        }
        return ans;
    }

}
