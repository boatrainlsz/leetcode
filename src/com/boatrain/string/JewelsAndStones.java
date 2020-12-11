package com.boatrain.string;

/**
 * https://leetcode-cn.com/problems/jewels-and-stones/
 * 给定字符串J代表石头中宝石的类型，
 * 和字符串S代表你拥有的石头。
 * S中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J中的字母不重复，J和S中的所有字符都是字母。
 * 字母区分大小写，因此"a"和"A"是不同类型的石头。
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        JewelsAndStones solution = new JewelsAndStones();
        System.out.println(solution.numJewelsInStones("z", "Z"));
    }

    public int numJewelsInStones(String J, String S) {
        if (S.length() == 0 || J.length() == 0) return 0;
        int[] count = new int[127];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'A']++;
        }
        int sum = 0;
        for (int i = 0; i < J.length(); i++) {
            sum += count[J.charAt(i) - 'A'];
        }
        return sum;
    }
}
