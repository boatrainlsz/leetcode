package com.boatrain.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dijkstra最短路算法
 * k->t的传播时间就是k->t的最短路距离
 * 求出k到所有点的最短路，求最大值即是答案
 */
public class NetworkDelayTime {
    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(solution.networkDelayTime(times, 4, 2));
    }

    List<Map<Integer, Integer>> graph = new ArrayList<>();
    //是否已经确定了k到此节点的最短路
    boolean[] confirmed;
    //k到此节点的最短路
    int[] distance;
    int n;

    public int networkDelayTime(int[][] times, int n, int k) {
        this.n = n;
        for (int i = 0; i < n + 1; i++) {
            graph.add(new HashMap<>());
        }
        for (int i = 0; i < times.length; i++) {
            int src = times[i][0];
            int dst = times[i][1];
            int cost = times[i][2];
            graph.get(src).put(dst, cost);
        }
        confirmed = new boolean[graph.size()];
        distance = new int[graph.size()];
        //初始化，k到所有节点最短距离都是正无穷，自身最短距离为0
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        dijkstra(k);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < distance.length; i++) {
            //有一个还没有确定，就说明不可达
            if (distance[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(distance[i], ans);
        }
        return ans;
    }

    private void dijkstra(int src) {
        //1.求出当前未确定最短路的节点的距离的最小值
        while (true) {
            int curDistance = Integer.MAX_VALUE, curNode = -1;
            for (int node = 1; node <= n; node++) {
                if (!confirmed[node] && distance[node] < curDistance) {
                    curDistance = distance[node];
                    curNode = node;
                }
            }
            //这个最小值就是k->curNode的最短路大小，因为其他未确定节点的最短路都比他大
            //从其他节点绕路来到k，距离只会更大
            if (curNode == -1) break;
            confirmed[curNode] = true;
            //2.根据curNode更新curNode的邻接节点
            Map<Integer, Integer> adjs = graph.get(curNode);
            for (Map.Entry<Integer, Integer> entry : adjs.entrySet()) {
                Integer adj = entry.getKey();
                if (!confirmed[adj]) {
                    if (distance[adj] > distance[curNode] + entry.getValue()) {
                        distance[adj] = distance[curNode] + entry.getValue();
                    }
                }
            }
        }
    }
}
