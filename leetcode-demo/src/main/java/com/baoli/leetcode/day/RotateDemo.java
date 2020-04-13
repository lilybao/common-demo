package com.baoli.leetcode.day;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-04-07 21:47
 */
public class RotateDemo {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(matrix[0][1]);
        int n =matrix.length;
        //对角线
        for (int i = 0; i < n-1 ;i++) {
            for (int j = i+1; j< n; j++) {
                int v =matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=v;
            }
        }
        int m = n>>1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp =matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=tmp;
            }
        }
        System.out.println(matrix);
    }
}
