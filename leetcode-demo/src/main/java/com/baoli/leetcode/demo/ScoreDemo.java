package com.baoli.leetcode.demo;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-03-20 19:28
 */
public class ScoreDemo {
    public static void main(String[] args) {
        int[][] arr = {{1, 60, 79, 43}, {2, 87, 65, 95}, {3, 65, 75, 76}};
        int w = arr[0].length + 1;
        int[][] ints = new int[arr.length][w];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                ints[i][j] = arr[i][j];
                if (j > 0) {
                    sum += arr[i][j];
                }
            }
            ints[i][ints[0].length - 1] = sum;
        }
        int[] ints1 = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i][w - 1] < ints[j][w - 1]) {
                    ints1 = ints[i];
                    ints[i] = ints[j];
                    ints[j] = ints1;
                }
            }

        }
        System.out.println(ints.toString());
    }

}
