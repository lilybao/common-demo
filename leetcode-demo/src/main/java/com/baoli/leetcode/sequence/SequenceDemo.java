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
        fastSortSearch(arr,0,arr.length-1);
        //快速排序
//        quickSequence(arr, 0, arr.length - 1);
        System.out.println(arr);
    }

    private static void quickSequence(int[] arr, int left, int right) {
        if (left < right) {
            int j = partition(arr, left, right);
            quickSequence(arr, left, j - 1);
            quickSequence(arr, j + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int tmp = arr[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (--j >= i && arr[j] > tmp) ;
            while (++i <= j && arr[i] < tmp) ;
            if (i >= j) {
                break;
            }
            int v = arr[j];
            arr[j] = arr[i];
            arr[i] = v;
        }
        arr[left] = arr[j];
        arr[j] = tmp;
        return j;
    }

    private static void bubbleSequence(int[] arr) {
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


    public static void  fastSortSearch(int arr[],int left ,int right){
        if(left<right){
            int j =partitions(arr,left,right);
            fastSortSearch(arr,left,j-1);
            fastSortSearch(arr,j+1,right);
        }
    }

    private static int partitions(int arr[], int left, int right) {
        int tmp =arr[left];
        int i=left ;int j=right+1;
        while (true){
            while(--j>=i&&arr[j]>tmp);
            while (++i<=j&&arr[i]<tmp);
            if(i>=j){
                break;
            }
            int v=arr[i];
            arr[i]=arr[j];
            arr[j]=v;
        }
        arr[left]=arr[j];
        arr[j]=tmp;
        return j;
    }


}
