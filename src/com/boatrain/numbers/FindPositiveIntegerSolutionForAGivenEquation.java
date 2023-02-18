package com.boatrain.numbers;

import java.util.ArrayList;
import java.util.List;

class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y) {
        return 1;
    }
}


public class FindPositiveIntegerSolutionForAGivenEquation {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            List<Integer> temp = new ArrayList<>();
            for (int y = 1; y <= 1000; y++) {
                if (customfunction.f(x, y) == z) {
                    temp.add(x);
                    temp.add(y);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}