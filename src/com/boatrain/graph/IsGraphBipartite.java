package com.boatrain.graph;

public class IsGraphBipartite {
    public static void main(String[] args) {
        IsGraphBipartite solution = new IsGraphBipartite();
        int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
//        int[][] graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(solution.isBipartite(graph));
    }

    //0:未访问过，1：颜色1：-1：颜色2
    int[] visited;

    public boolean isBipartite(int[][] graph) {
        visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (!dfs(graph, i)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int v) {
        int[] adjs = graph[v];
        for (int adj : adjs) {
            if (visited[adj] == visited[v] && visited[adj] != 0) return false;
            if (visited[adj] == 0) {
                visited[adj] = -visited[v];
                if (!dfs(graph, adj)) return false;
            }
        }
        return true;
    }
}
