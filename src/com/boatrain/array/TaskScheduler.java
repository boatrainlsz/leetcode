package com.boatrain.array;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler solution = new TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;
        System.out.println(solution.leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {
        int maxCount = Integer.MIN_VALUE;
        int[] array = new int[26];
        for (char task : tasks) {
            array[task - 'A']++;
        }
        int fuck = 0;
        for (int count : array) {
            maxCount = Math.max(maxCount, count);
        }
        int minTime = (maxCount - 1) * (n + 1);
        for (int count : array) {
            if (count == maxCount) fuck++;
        }
        return Math.max(minTime + fuck, tasks.length);
    }
}
