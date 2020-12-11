package com.boatrain.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/partition-labels/
 * 字符串 S 由小写字母组成。
 * 我们要把这个字符串划分为尽可能多的片段，
 * 同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */
public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels solution = new PartitionLabels();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        //记录每个字母最后出现的下标
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            lastIndexMap.put(S.charAt(i), i);
        }
        //双指针
        int start = 0;
        int end = 0;
        while (start < length && end < length) {
            end = lastIndexMap.get(S.charAt(start));
            int temp = start;
            while (start <= end) {
                end = Math.max(end, lastIndexMap.get(S.charAt(start)));
                start++;
            }
            result.add(end - temp + 1);
            start = end + 1;
            end = end + 1;
        }
        return result;
    }
}
