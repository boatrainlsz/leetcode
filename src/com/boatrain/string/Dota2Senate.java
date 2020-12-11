package com.boatrain.string;

/**
 * https://leetcode-cn.com/problems/dota2-senate/
 */
public class Dota2Senate {
    public static void main(String[] args) {
        Dota2Senate solution = new Dota2Senate();
        System.out.println(solution.predictPartyVictory("RDD"));
    }

    public String predictPartyVictory(String senate) {
        int length = senate.length();
        char[] charArray = senate.toCharArray();
        //D方议员总个数
        int dCount = 0;
        //R方议员总个数
        int rCount = 0;
        //当前待被禁言的D方议员个数
        int dWaitForbidCount = 0;
        //当前待被禁言的R方议员个数
        int rWaitForbidCount = 0;
        //先统计两方议员总个数
        for (char c : charArray) {
            if (c == 'R') {
                rCount++;
            } else {
                dCount++;
            }
        }
        while (true) {
            for (int i = 0; i < length; i++) {
                char c = charArray[i];
                if (dCount == 0) {
                    //D方全禁言了，R方胜利
                    return "Radiant";
                }
                if (rCount == 0) {
                    //R方全禁言了，D方胜利
                    return "Dire";
                }
                if (c == 'R') {
                    if (rWaitForbidCount != 0) {
                        //R方议员出来被禁言
                        rWaitForbidCount--;
                        charArray[i] = 'N';
                    } else {
                        //否则，R方议员申请禁言D方
                        dCount--;
                        dWaitForbidCount++;
                    }
                }
                if (c == 'D') {
                    if (dWaitForbidCount != 0) {
                        //D方议员出来被禁言
                        dWaitForbidCount--;
                        charArray[i] = 'N';
                    } else {
                        //否则，D方议员申请禁言R方
                        rCount--;
                        rWaitForbidCount++;
                    }
                }
            }
        }
    }
}
