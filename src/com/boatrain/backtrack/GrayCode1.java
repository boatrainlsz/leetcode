package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrayCode1 {
    public static void main(String[] args) {
        GrayCode1 solution = new GrayCode1();
        System.out.println(solution.grayCode(6));

    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0));
        Set<Integer> history = new HashSet<>();
        generateGrayCode(n, history, result);
        return result;
    }

    private boolean generateGrayCode(int n, Set<Integer> history, List<Integer> result) {
        // base case
        if (result.size() == (1 << n)) {
            // check the first element and the last element
            return isValid(result.get(0), result.get(result.size() - 1));
        }
        for (int i = 0; i < n; ++i) {
            int prevCode = result.get(result.size() - 1);
            int candCode = prevCode ^ (1 << i);
            if (!history.contains(candCode)) {
                history.add(candCode);
                result.add(candCode);
                boolean found = generateGrayCode(n, history, result);
                if (found) return true;
                history.remove(candCode);
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    private boolean isValid(int n1, int n2) {
        int xor = n1 ^ n2;
        return xor != 0 && (xor & (xor - 1)) == 0;
    }
}
