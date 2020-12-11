package com.boatrain.array;

import java.util.HashMap;
import java.util.Map;

class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        //key为数字，value为数字出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        //key为数字，value为以该数字结尾的长度至少为3的数组个数
        Map<Integer, Integer> tailMap = new HashMap<>();
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }
        for (int num : nums) {
            if (countMap.getOrDefault(num, 0) == 0) {
                //如果当前数字用完了，跳过
                continue;
            } else if (tailMap.getOrDefault(num - 1, 0) != 0) {
                //如果以num-1结尾的数组存在，就把num放在它后面
                countMap.put(num, countMap.getOrDefault(num, 0) - 1);
                tailMap.put(num - 1, tailMap.getOrDefault(num - 1, 0) - 1);
                tailMap.put(num, tailMap.getOrDefault(num, 0) + 1);
            } else if (countMap.getOrDefault(num + 1, 0) != 0 &&
                    countMap.getOrDefault(num + 2, 0) != 0) {
                //如果以num-1结尾的数组不存在，但num+1和num+2存在，就以[num,num+1,num+2]组成新数组
                tailMap.put(num + 2, tailMap.getOrDefault(num + 2, 0) + 1);
                countMap.put(num, countMap.get(num) - 1);
                countMap.put(num + 1, countMap.getOrDefault(num + 1, 0) - 1);
                countMap.put(num + 2, countMap.getOrDefault(num + 2, 0) - 1);
            } else {
                //如果以num-1结尾的数组不存在，且num+1和num+2有一个不存在，说明num无处可去，直接返回false
                return false;
            }
        }
        return true;
    }
}