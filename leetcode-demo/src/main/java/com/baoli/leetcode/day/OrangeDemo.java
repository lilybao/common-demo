package com.baoli.leetcode.day;

import java.util.*;

public class OrangeDemo {
    public static void main(String[] args) {
//        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
//        int[][] grid = {{1, 1, 2, 0, 2, 0}};
//        int[][] grid = {{1, 2, 1,1,2,1,1}};
//        int[][] grid = {{1, 1, 1}};
//        int[][] grid = {{1,0,0,0,2,1,0}};
        int[][] grid = {{2},{1},{1},{1},{2},{1},{1}};

//        int[][] grid = {{0,2}};
//        int[][] grid = {{0}};
//        System.out.println(grid[0][0]);
//        int count = getCount(grid);
//        int minutes = 0;
        int badCount = getBadCount2(grid);
        System.out.println(badCount);

    }

    /**
     * 广度优先搜索算法    利用队列存放坏掉的橘子  map存放最短路径
     * 时间复杂度  算法执行一次的  O(nm)  空间复杂度  队列中最多存放  O(nm )
     * @param grid
     * @return
     */
    private static int getBadCount2(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int c = 10;
        HashMap<Integer, Integer> badTimes = new HashMap<>();
        Queue<Object> bads = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    int bad = j * c + i;
                    bads.add(bad);
                    badTimes.put(bad, 0);
                }
            }
        }
        int time = 0;
        while (!bads.isEmpty()) {
            Integer bad = (Integer) bads.remove();
            int x = bad / c;
            int y = bad % c;
            for (int i = 0; i < 4; i++) {
                int x1=x+dx[i];
                int y1=y+dy[i];
                if (0 <= x1 && x1 < grid[0].length && 0 <= y1 && y1 < grid.length && grid[y1][x1] == 1) {
                    grid[y1][x1] = 2;
                    int nbad = x1 * c + y1;
                    bads.add(nbad);
                    badTimes.put(nbad, badTimes.get(bad) + 1);
                    time = badTimes.get(nbad);
                }

            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    public static int getBadCount1(int[][] grid) {
        ArrayList<String> bads = new ArrayList<>();
        ArrayList<String> newbads = new ArrayList<>();
        ArrayList<String> goods = new ArrayList<>();
        int good;
        int time = 0;
        while (true) {
            if (newbads.size() != 0) {
                newbads.clear();
            }
            if (goods.size() != 0) {
                goods.clear();
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2 && !bads.contains(i + "-" + j)) {
                        newbads.add(i + "-" + j);
                    }
                    if (grid[i][j] == 1) {
                        goods.add(i + "-" + j);
                    }
                }
            }
            bads.addAll(newbads);
            good = goods.size();
            if (newbads.size() != 0) {
                int c = 0;
                for (String bad : newbads) {
                    String[] split = bad.split("-");
                    int i = Integer.valueOf(split[0]);
                    int j = Integer.valueOf(split[1]);
                    if (changeBad1(i, j, grid, good)) {
                        c++;
                    }
                }
                if (c > 0) {
                    time++;
                }
            }

            if (newbads.size() == 0) {
                break;
            }
            if (newbads.size() != 0 && good == 0) {
                break;
            }
        }
        if (good != 0) {
            return -1;
        }
        return time;
    }


    //获取所有的2
    public static int getBadCount(int[][] grid, int minutes, int length) {
        length++;
        ArrayList<String> bads = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    bads.add(i + "-" + j);
                }
            }
        }
        boolean f = false;
        if (bads.size() != 0) {
            int c = 0;
            for (String bad : bads) {
                String[] split = bad.split("-");
                int i = Integer.valueOf(split[0]);
                int j = Integer.valueOf(split[1]);
                if (changeBad(i, j, grid, minutes)) {
                    c++;
                }
            }
            if (c > 0) {
                minutes++;
            }
            if (length >= grid.length * grid[0].length) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] == 1) {//有橘子永远不会腐烂
                            return -1;
                        }
                    }
                }
                return minutes;
            }
            minutes = getBadCount(grid, minutes, length);

        } else {
            if (length == 1) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] == 1) {
                            return -1;
                        }
                    }
                }
                return 0;
            }
            return minutes;
        }
        return minutes;
    }

    private static boolean changeBad(int i, int j, int[][] grid, int minutes) {
        boolean flag = false;
        if (0 <= (i - 1) && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;
            flag = true;
        }
        if ((j + 1) < grid[0].length && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;
            flag = true;
        }
        if (0 <= (j - 1) && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;
            flag = true;
        }
        if ((i + 1) < grid.length && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;
            flag = true;
        }
        return flag;
    }


    private static boolean changeBad1(int i, int j, int[][] grid, int goods) {
        boolean flag = false;
        if (0 <= (i - 1) && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;
            goods--;
            flag = true;
        }
        if ((j + 1) < grid[0].length && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;
            goods--;
            flag = true;
        }
        if (0 <= (j - 1) && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;
            goods--;
            flag = true;
        }
        if ((i + 1) < grid.length && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;
            goods--;
            flag = true;
        }
        return flag;
    }

}
