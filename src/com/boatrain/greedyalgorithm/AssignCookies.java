package com.boatrain.greedyalgorithm;

import java.util.Arrays;

/**
 * 分饼干：https://leetcode-cn.com/problems/assign-cookies/
 */
public class AssignCookies {
    public static void main(String[] args) {
        AssignCookies solution = new AssignCookies();
        int[] g = new int[]{1, 2, 3, 4, 5, 6};
        int[] s = new int[]{4, 5, 6};
        System.out.println(solution.findContentChildren(g, s));
    }

    /**
     * 抠门的算法，从小开始分配
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] > s[j]) {
                j++;
            } else {
                i++;
                j++;
                res++;
            }
        }
        return res;
    }

    /**
     * 大方的算法，从大开始分配
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = g.length - 1;
        int j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (g[i] <= s[j]) {
                j--;
                i--;
                res++;
            } else {
                i--;
            }
        }
        return res;
    }
}
