package com.boatrain.stackandqueue;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/simplify-path
 */
public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath solution = new SimplifyPath();
        String path = "/home//foo/";
//        String path = "/a/./b/../../c/";
//        String path = "/a/./b/../../c/";
        System.out.println(solution.simplifyPath(path));
    }

    public String simplifyPath(String path) {
        LinkedList<String> deque = new LinkedList<>();
        String[] paths = path.split("/");
        for (String item : paths) {
            if ("..".equals(item)) {
                deque.pollLast();
            } else if (!"".equals(item) && !"/".equals(item) && !".".equals(item)) {
                deque.offerLast(item);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()) {
            ans.append("/").append(deque.pollFirst());
        }
        return ans.toString().length() == 0 ? "/" : ans.toString();
    }
}
