package com.boatrain.array.mod;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 */
public class BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {
        BinaryPrefixDivisibleBy5 solution = new BinaryPrefixDivisibleBy5();
        int[] A = {0, 1, 1, 1, 1, 1};
        System.out.println(solution.prefixesDivBy5(A));
    }

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int remainder = 0;
        for (int num : A) {
            remainder = ((remainder << 1) + num) % 5;
            ans.add(remainder == 0);
        }
        return ans;
    }
}
