package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 */
public class AllPathsFromSourceToTarget {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        find(graph, 0, list);
        return ans;
    }

    private void find(int[][] graph,
                      int node, ArrayList<Integer> path) {
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (graph[node].length == 0) return;
        for (int dst : graph[node]) {
            path.add(dst);
            find(graph, dst, path);
            path.remove(path.size() - 1);
        }
    }
}
