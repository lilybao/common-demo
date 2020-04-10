package com.baoli.leetcode.day;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: common-demo
 * @description: 获取二维 m*n 纵向横向递增矩阵的值是否存在
 * @author: li baojian
 * @create: 2020-04-09 10:37
 */
public class SearchMatrixDemo {
    public static void main(String[] args) {

        int target=20;
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        int[][] matrix = {{15}};
//        boolean a = searchMatrix(matrix,target);
//        boolean a = searchMatrix1(matrix,target);
        boolean a = binarySearchMatrix(matrix,target);
        System.out.println(a);
    }
    //时间复杂度 O（m+n）
    private static boolean searchMatrix1(int[][] matrix, int target) {
        int col=0;
        int row=matrix.length-1;
        while (row>=0&&col<matrix[0].length){
            if(matrix[row][col]<target){
                col++;
            }else if(matrix[row][col]>target){
                row--;
            }else {
            return true;
            }
        }
        return false;
    }
    //二分查找 时间复杂度 O(log n)
    //本次查找的时间复杂度 k=min(m,n)  O(（logk+logk-1..）*2)=O（log(k!)*2）
    private static boolean binarySearchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0){
            return false;
        }
        int shortdim=Math.min(matrix.length,matrix[0].length);
        for (int i = 0; i < shortdim; i++) {
            boolean rowBoolean=bianrySearch(matrix,i,target,true);
            boolean colBoolean=bianrySearch(matrix,i,target,false);
            if(rowBoolean||colBoolean){
                return true;
            }
        }
        HashMap<Object, Object> map = new HashMap<>();
        ConcurrentHashMap<Object, Object> map1 = new ConcurrentHashMap<>();
        map1.put("","");
        map1.get("");
        map.put("","");
        return false;
    }

    private static boolean bianrySearch(int[][] matrix, int start, int target, boolean isRow) {
        int lo=start;
        int hi=isRow?matrix[0].length-1:matrix.length-1;
        while (hi>=lo){
            int mid =(hi+lo)/2;
            if(isRow){
                if(target>matrix[start][mid]){
                    lo=mid+1;
                }else if(target<matrix[start][mid]){
                    hi=mid-1;
                }else {
                    return true;
                }
            }else {
                if(target>matrix[mid][start]){
                    lo=mid+1;
                }else if(target<matrix[mid][start]){
                    hi=mid-1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0){
            return false;
        }
        int n=matrix[0].length;

        for (int i = m-1; i >=0 ; i--) {
            for (int j = 0; j <=n-1 ; j++) {
                if(matrix[i][j]==target){
                    return true;
                }
                if(matrix[i][j]<target){
                    continue;
                }
                if(matrix[i][j]>target){
                    break;
                }
            }
        }
        return false;
    }
}
