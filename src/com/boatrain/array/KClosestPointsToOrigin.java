package com.boatrain.array;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();
        int[][] points = new int[][]{
                {3, 3},
                {5, -1},
                {-2, 4},
        };
        System.out.println(Arrays.deepToString(solution.kClosest(points, 2)));
    }

    public int[][] kClosest(int[][] points, int K) {
        //优先队列
        PriorityQueue<int[]> heap = new PriorityQueue((Comparator<int[]>) (o1, o2) ->
                o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1]);
        for (int[] point : points) {
            if (heap.size() != K) {
                heap.add(point);
            } else if (closerThanPeek(heap.peek(), point)) {
                heap.poll();
                heap.add(point);
            }
        }
        int[][] result = new int[heap.size()][];
        List<int[]> list = new ArrayList<>(heap);
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private boolean closerThanPeek(int[] peek, int[] point) {
        return point[0] * point[0] + point[1] * point[1] - peek[0] * peek[0] - peek[1] * peek[1] < 0;

    }
}
