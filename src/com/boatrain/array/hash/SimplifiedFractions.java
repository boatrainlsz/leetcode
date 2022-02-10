package com.boatrain.array.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        HashSet<String> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int gcd = gcd(j, i);
                if (gcd == 1) {
                    set.add(j + "/" + i);
                }
            }
        }
        return new ArrayList<>(set);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}