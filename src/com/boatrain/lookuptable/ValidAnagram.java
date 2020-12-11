package com.boatrain.lookuptable;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution.isAnagram(s, t));
    }

    /**
     * 用数组存储次数
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        //字母出现的次数相同即满足
        if (s.length() != t.length()) return false;
        int[] freqS = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - 'a'] = freqS[s.charAt(i) - 'a'] + 1;
        }
        int[] freqT = new int[26];
        for (int i = 0; i < t.length(); i++) {
            freqT[t.charAt(i) - 'a'] = freqT[t.charAt(i) - 'a'] + 1;
        }
        for (int i = 0; i < t.length(); i++) {
            if (freqT[t.charAt(i) - 'a'] != freqS[t.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用map存储次数
     * @param s
     * @param t
     * @return
     */
//    public boolean isAnagram(String s, String t) {
//        //字母出现的次数相同即满足
//        if (s.length() != t.length()) return false;
//        int[] freqS = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            freqS[s.charAt(i) - 'a'] = freqS[s.charAt(i) - 'a'] + 1;
//        }
//        int[] freqT = new int[26];
//        for (int i = 0; i < t.length(); i++) {
//            freqT[t.charAt(i) - 'a'] = freqT[t.charAt(i) - 'a'] + 1;
//        }
//        for (int i = 0; i < t.length(); i++) {
//            if (freqT[t.charAt(i) - 'a'] != freqS[t.charAt(i) - 'a']) {
//                return false;
//            }
//        }
//        return true;
//    }
}
