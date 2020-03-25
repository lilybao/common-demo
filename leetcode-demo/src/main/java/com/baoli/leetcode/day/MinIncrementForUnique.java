package com.baoli.leetcode.day;

import java.util.Arrays;

/**
 * @program: common-demo
 * @description: 最小的增加是每个数字都唯一  minIncrementForUnique
 * @author: li baojian
 * @create: 2020-03-23 09:39
 */
public class MinIncrementForUnique {
    public static void main(String[] args) {
//        int[] A = {1, 2, 6, 2, 1, 5, 3};
//        int[] A = {1,1,1};
        int[] A = {1, 1, 1, 1, 2};
        int num = getMinCount(A);
        System.out.println(num);
    }

    private static int getMinCount(int[] A) {
        int count = 0;
        Arrays.sort(A);
        int sum = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                count++;
                sum -= A[i];
            } else {
                int min = Math.min(count, A[i] - A[i - 1] - 1);
                sum += A[i - 1] * min + (min + 1) * min / 2;
                count -= min;
            }
        }
        if (count > 0) {
            sum += A[A.length - 1] * count + (1 + count) * count / 2;
        }
        return sum;
    }
}
