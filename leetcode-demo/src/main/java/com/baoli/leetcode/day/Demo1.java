package com.baoli.leetcode.day;

import java.util.Arrays;

/**
 * @program: common-demo
 * @description: 最小的增加是每个数字都唯一
 * @author: li baojian
 * @create: 2020-03-23 09:39
 */
public class Demo1 {
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
        int now = 0;
        for (int i = 0; i < A.length; i++) {
            now = A[i];
            int k = i + 1;
            while ((k < A.length)) {
                if (now == A[k]) {
                    now++;
                    count++;

                }
                k++;
            }
            if (now > A[i]) {
                int j = i + 1;
                while (j < A.length) {
                    if (now < A[j]) {
                        break;
                    }
                    A[j - 1] = A[j];
                    j++;
                }
                A[j - 1] = now;
                i = i - 1;
            }
        }
        return count;
    }
}
