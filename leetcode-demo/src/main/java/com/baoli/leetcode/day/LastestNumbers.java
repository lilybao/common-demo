package com.baoli.leetcode.day;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: common-demo
 * @description: 最小个数的数字
 * @author: li baojian
 * @create: 2020-03-20 09:47
 */
public class LastestNumbers {
    public static void main(String[] args) {
//        int[] arr = {3, 2, 1, 0, 0};
        int[] arr = {0,0,1,2,4,2,2,3,1,4};
        int k = 8;
        int[] numbers = getLeastNumbers(arr, k);
        //        Arrays.sort(arr);
        //        Arrays.copyOf(arr,k-1);
        int [] n=fastSearch(arr,k);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
    //快排
    private static int[] fastSearch(int[] arr, int k) {
        if(k==0||arr.length==0){
            return new int[0];
        }
        return  quickSearch(arr, 0, arr.length - 1, k-1);
    }


    private static int[] quickSearch(int[] arr, int lo, int hi, int k) {
        int j = partition(arr, lo, hi);
        if (j == k) {
            return Arrays.copyOf(arr, j + 1);
        }
        return j > k ? quickSearch(arr, lo, j - 1, k) : quickSearch(arr, j + 1, hi, k);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int v = arr[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && arr[i] < v) ;
            while (--j >= lo && arr[j] > v) ;
            if (i >= j) {
                break;
            }
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        arr[lo]=arr[j];
        arr[j]=v;
        return j;
    }

    //时间复杂度  arr.length!(k)
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] ints = new int[k];
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    m = arr[j];
                    arr[j] = arr[i];
                    arr[i] = m;
                }
            }
            if (i < k) {
                ints[i] = arr[i];
            }

        }
        return ints;
    }
}
