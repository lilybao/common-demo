package com.baoli.leetcode.day;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: common-demo
 * @description: 区间合并
 * @author: li baojian
 * @create: 2020-04-16 22:16
 */
public class MergeDemo {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3},  {8, 10}, {15, 18},{2, 6}};
        int[][] merge = merge(intervals);
        System.out.println(merge);




    }

    public static int[][] merge(int[][] intervals) {
        quicksort(intervals, 0, intervals.length - 1);
        int[][] arr=new int[intervals.length][2];
        int index=-1;
        for (int[] interval:intervals) {
            if(index==-1||interval[0]>arr[index][1]){
                arr[++index]=interval;
            }else {
                arr[index][1]=Math.max(arr[index][1],interval[1]);
            }
        }

        return Arrays.copyOf(arr,index+1);
    }


    private static void quicksort(int[][] intervals, int left, int right) {
        if (left < right) {
            int index = partition(intervals, left, right);
            quicksort(intervals, left, index - 1);
            quicksort(intervals, index + 1, right);
        }

    }

    private static int partition(int[][] intervals, int left, int right) {
        int tmp = intervals[left][0];
        int tmp1 = intervals[left][1];
        int i = left;
        int j = right + 1;
        while (true) {
            while (--j >= i && intervals[j][0] > tmp) ;
            while (++i <= j && intervals[i][0] < tmp) ;
            if (i >= j) {
                break;
            }
            int m0 = intervals[j][0];
            int m1 = intervals[j][1];
            intervals[j][0] = intervals[i][0];
            intervals[j][1] = intervals[i][1];
            intervals[i][0] = m0;
            intervals[i][1] = m1;
        }
        intervals[left][0]=intervals[j][0];
        intervals[left][1]=intervals[j][1];
        intervals[j][0]=tmp;
        intervals[j][1]=tmp1;
        return j;
    }

}
