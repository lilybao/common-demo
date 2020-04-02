package com.baoli.leetcode.sequence;

/**
 * @program: common-demo
 * @description: 排序
 * @author: li baojian
 * @create: 2020-04-02 16:50
 */
public class SequenceDemo {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 23, 65, 7, 8, 7, 8};
        //冒泡排序
//        slowSequence(arr);


        //快速排序
        quickSequence(arr, 0, arr.length - 1);
        System.out.println(arr);
    }

    private static void slowSequence(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int a = arr[j];
                    arr[j] = arr[i];
                    arr[i] = a;
                }
            }
        }
    }

    private static void quickSequence(int[] arr, int left, int right) {
        if(right<left){
            return;
        }
        int tmp = arr[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[j] >= tmp && j > i) {
                j--;
            }
            while (arr[i] <= tmp && i < j) {
                i++;
            }
            if (i < j) {
                int n = arr[j];
                arr[j--] = arr[i];
                arr[i++] = n;
            }
        }
        if(arr[i]>arr[right]){
            arr[right] = arr[i];
            arr[i] = tmp;
        }
        quickSequence(arr, left, i- 1);
        quickSequence(arr, i + 1, right);

    }


}
