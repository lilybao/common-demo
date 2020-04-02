package com.baoli.leetcode.day;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @program: common-demo
 * @description: 最大距离
 * @author: li baojian
 * @create: 2020-04-01 09:47
 */
public class MaxDistanceDemo {
    public static void main(String[] args) {

        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        long l = System.currentTimeMillis();
        int i = maxDistance(grid);
        System.out.println(i + "=" + (System.currentTimeMillis() - l));
    }

    public static int maxDistance(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        if (queue.isEmpty() || queue.size() == grid.length * grid.length) {
            return -1;
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            x = poll[0];
            y = poll[1];
            for (int i = 0; i < dx.length; i++) {
                int newX = poll[0] + dx[i];
                int newY = poll[1] + dy[i];
                if (newX < 0 || newX >= grid[0].length || newY < 0 || newY >= grid.length || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[poll[0]][poll[1]] + 1;
                queue.offer(new int[]{newX, newY});
            }
        }
        return grid[x][y] - 1;
    }

    static class Tree {
        public boolean flag;
        private int x;
        private int y;
        private Tree tree;

        public Tree(int x, int y) {
            this.flag = true;
            this.x = x;
            this.y = y;
        }
    }
}
