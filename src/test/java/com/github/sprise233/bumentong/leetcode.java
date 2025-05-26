package com.github.sprise233.bumentong;

import java.util.*;

public class leetcode {
    public static void main(String[] args) {

        System.out.println(new Solution().largestPathValue("abaca", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}}));
    }
}

class Solution {
    public int largestPathValue(String colors, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[colors.length()];

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < colors.length(); i++) {
            if (indegree[i] == 0) queue.offer(i);
        }


        int max = 1;
        int visitNum = 0;
        int[][] dp = new int[colors.length()][26];
        for (int i = 0; i < colors.length(); i++) {
            dp[i][colors.charAt(i) - 'a'] = 1;
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            visitNum ++;
            if (map.get(node) != null) {
                for (Integer child : map.get(node)) {
                    indegree[child] --;
                    if (indegree[child] == 0) {
                        queue.add(child);
                    }
                    for (int i = 0; i < 26; i++) {
                        dp[child][i] = Math.max(dp[child][i], dp[node][i] + (colors.charAt(child) - 'a' == i ? 1 : 0));
                        max = Math.max(max, dp[child][i]);
                    }
                }
            }


        }

        return visitNum == colors.length() ? max : -1;
    }
}