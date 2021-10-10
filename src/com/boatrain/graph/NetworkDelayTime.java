package com.boatrain.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelayTime {
    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(solution.networkDelayTime(times, 4, 2));
    }

    List<HashMap<Integer, Integer>> graph = new ArrayList<>();
    boolean[] visited;
    int ans = -1;

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int i = 1; i <= n + 1; i++) {
            graph.add(new HashMap<>());
        }
        for (int i = 0; i < times.length; i++) {
            graph.get(times[i][0]).put(times[i][1], times[i][2]);
        }
        visited = new boolean[graph.size()];
        visited[k] = true;
        dfs(k, 0);
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) return -1;

        }
        return ans;
    }

    private void dfs(int node, int curCost) {
        boolean reachEnd = true;
        HashMap<Integer, Integer> adjs = graph.get(node);
        for (Integer adj : adjs.keySet()) {
            if (!visited[adj]) {
                reachEnd = false;
                break;
            }
        }
        if (reachEnd) {
            ans = Math.max(curCost, ans);
        }
        for (Map.Entry<Integer, Integer> entry : adjs.entrySet()) {
            Integer adj = entry.getKey();
            if (!visited[adj]) {
                visited[adj] = true;
                Integer cost = entry.getValue();
                dfs(adj, cost+curCost);
            }
        }
    }
}
