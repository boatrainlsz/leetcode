package com.boatrain.interview.microsoft;

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

/**
 * 假设你是一个专业的狗仔，参加了一个n人派对，其中每个人被从0到n - 1标号。在这个派对人群当中可能存在一位“名人”。所谓 “名人” 的定义是：其他所有n - 1个人都认识他/她，而他/她并不认识其他任何人。
 * <p>
 * 现在你想要确认这个 “名人” 是谁，或者确定这里没有“名人”。而你唯一能做的就是问诸如 “A你好呀，请问你认不认识B呀？”的问题，以确定 A 是否认识 B。你需要在（渐近意义上）尽可能少的问题内来确定这位 “名人” 是谁（或者确定这里没有 “名人”）。
 * <p>
 * 在本题中，你可以使用辅助函数bool knows(a, b)获取到 A是否认识 B。请你来实现一个函数int findCelebrity(n)。
 * <p>
 * 派对最多只会有一个 “名人” 参加。若“名人” 存在，请返回他/她的编号；若“名人”不存在，请返回-1。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-celebrity
 */

/**
 * 设待定名人celebrity为0， 遍历每一个人，celebrity认识另一个人i，说明他不是名人，把i变成名人。
 * 最后再判断是不是所有人都认识他，而他不认识所有人
 * 为什么第一步能找到可能的名人（出度可能为0）证明：
 * 反证法： 假如找到celebrity的不是名人，说明出度不为0。
 * 但若该celebrity出度不为0，则轮到celebrity的时候一定会转移，矛盾。
 * <p>
 * 那有没有可能漏掉名人呢？答案是否定的，因为名人一定不认识其他人，并且其他人都是认识他，迭代了n次之后，最后会收敛到一定是名人。
 */

public class FindCelebrity {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        for (int i = 0; i < n && i != celebrity; i++) {
            if (knows(celebrity, i) && !knows(i, celebrity)) return -1;
        }
        return celebrity;
    }

    private boolean knows(int a, int b) {
        //调用题目中的接口
        return false;
    }
}