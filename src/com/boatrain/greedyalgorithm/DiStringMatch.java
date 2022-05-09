package com.boatrain.greedyalgorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class DiStringMatch {
    public static void main(String[] args) {
        DiStringMatch solution = new DiStringMatch();
        System.out.println(Arrays.toString(solution.diStringMatch("IDID")));
    }
    public int[] diStringMatch(String s) {
        int[] ans = new int[s.length()+1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < s.length() + 1; i++) {
            queue.addLast(i);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I') {
                ans[i] = queue.removeFirst();
            } else {
                ans[i] = queue.removeLast();
            }
        }
        ans[ans.length - 1] = queue.removeFirst();
        return ans;
    }
}