package com.boatrain.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 */
class DecodeWays {
    private Integer[] mem;

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("1234"));
    }

    //A-1 B-2...Z-26
    public int numDecodings(String s) {
        if ("0".equals(s)) return 0;
        if (s.length() == 1) return 1;
        mem = new Integer[s.length()];
        return findNumDecodings(s, 0);
    }

    public int findNumDecodings(String s, int index) {
        //到达最后一个字符
        if (index == s.length()) return 1;

        char cur = s.charAt(index);
        //0开头，直接返回0
        if (cur == '0') return 0;
        //就一个数字，直接返回1
        if (index == s.length() - 1) return 1;
        //优先从备忘录中找，找到则直接返回
        if (mem[index] != null) return mem[index];
        //大于等于3,则只能单独组成一个编码，无法和后面的组合
        if (cur >= '3') {
            return findNumDecodings(s, index + 1);
        }
        //cur=1或2
        char next = s.charAt(index + 1);
        //下一位等于0，则0必须和cur组合才有意义，比如单独的0、或者01都是无意义的
        if (next == '0') {
            mem[index] = findNumDecodings(s, index + 2);
            return mem[index];
        }
        //下一位大于0且小于等于6，则有可能是单独的，也有可能和1或2一起
        if (next <= '6') {
            mem[index] = findNumDecodings(s, index + 1) + findNumDecodings(s, index + 2);
            return mem[index];
        }
        //cur=1，但next>=7,则cur可以单独，也可以和next一起
        if (cur == '1') {
            mem[index] = findNumDecodings(s, index + 1) + findNumDecodings(s, index + 2);
            return mem[index];
        }
        //cur=2,next>7
        mem[index] = findNumDecodings(s, index + 1);
        return mem[index];

    }
}
