package com.boatrain.stackandqueue;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 2, 2, 3};
        TopKFrequent solution = new TopKFrequent();
        System.out.println(Arrays.toString(solution.topKFrequent(array, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        //统计每个数的频数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }
        //最小堆，以频数作为比较“大小”的依据，“大小”是指频数的大小
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(countMap::get));
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (minHeap.size() == k) {
                //堆元素已经达到了K个，比较堆顶元素和要加入元素的“大小”
                if (countMap.get(minHeap.peek()) < entry.getValue()) {
                    minHeap.remove();
                    minHeap.add(entry.getKey());
                }
            } else {
                //堆元素还不足K个
                minHeap.add(entry.getKey());
            }
        }
        //最后保存的就是出现次数前K个的数
        List<Integer> list = new ArrayList<>(minHeap);
        int[] array = new int[k];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
