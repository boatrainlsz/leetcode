package com.boatrain.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题就是判断有向图中是否有环
 * 用一个visited+onPath进行dfs就行
 * 讲解可看liuyubobo图论精讲的有向图章节
 */
public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 2;
//        int numCourses = 2;
//        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};
        int[][] prerequisites = new int[][]{{1, 0}};
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }

    boolean[] visited;
    boolean[] onPath;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for (int i = 0; i < numCourses; i++)
            if (dfs(adjacency, i)) return false;
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int course) {
        visited[course] = true;
        onPath[course] = true;
        for (Integer dst : adjacency.get(course)) {
            if (!visited[dst]) {
                if (dfs(adjacency, dst)) return true;
            } else if (onPath[dst]) {
                return true;
            }
        }
        onPath[course] = false;
        return false;
    }
}