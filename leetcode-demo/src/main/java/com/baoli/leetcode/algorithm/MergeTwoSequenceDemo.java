package com.baoli.leetcode.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: common-demo
 * @description: 合并两个有序数组
 * @author: li baojian
 * @create: 2020-04-27 15:20
 */
public class MergeTwoSequenceDemo {

    /**
     * 合并两个有序数组   到另一个数组中
     */
    @Test
    public void mergeTwoSequence(){

        int[] nums1={0,0,1,2,3,0,0,0};
        int[] nums2={2,5,6};
        int m=5;
        int n=3;
        int[] arr=mergeTwo2(nums1,m,nums2,n);
//        int[] arr=mergeTwo(nums1,nums2);
        System.out.println(arr.toString());

    }

    private int[] mergeTwo2(int[] nums1, int m, int[] nums2, int n) {
        int arr1Index=m-1;
        int arr2Index=n-1;
        int i=nums1.length-1;
        while (arr1Index>=0||arr2Index>=0){
            if(arr1Index>=0&&arr2Index>=0){
                if(nums1[arr1Index]>nums2[arr2Index]){
                    nums1[i--]=nums1[arr1Index--];
                }else{
                    nums1[i--]=nums2[arr2Index--];
                }
            }else if(arr1Index>=0){
                nums1[i--]=nums1[arr1Index--];
            }else if(arr2Index>=0){
                nums1[i--]=nums2[arr2Index--];
            }else {
                break;
            }
        }
        return nums1;
    }

    private int[] mergeTwo1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy=new int[m];
        System.arraycopy(nums1,0,nums1Copy,0,m);
        int arr1Index=0;
        int arr2Index=0;
        int i=0;
        while (arr1Index<m||arr2Index<n){
            if(arr1Index<m&&arr2Index<n){
                if(nums1Copy[arr1Index]<nums2[arr2Index]){
                    nums1[i++]=nums1Copy[arr1Index++];
                }else{
                    nums1[i++]=nums2[arr2Index++];
                }
            }else if(arr1Index<m){
                nums1[i++]=nums1Copy[arr1Index++];
            }else if(arr2Index<n){
                nums1[i++]=nums2[arr2Index++];
            }else {
                break;
            }
        }
        return nums1;
    }

    private int[] mergeTwo(int[] nums1, int m, int[] nums2, int n) {
        int[] arr=new int[m];
        int arr1Index=0;
        int arr2Index=0;
        int i=0;
        while (arr1Index<m||arr2Index<n){
            if(arr1Index<m&&arr2Index<n){
                if(nums1[arr1Index]<nums2[arr2Index]){
                    arr[i++]=nums1[arr1Index++];
                }else{
                    arr[i++]=nums2[arr2Index++];
                }
            }else if(arr1Index<m){
                arr[i++]=nums1[arr1Index++];
            }else if(arr2Index<n){
                arr[i++]=nums2[arr2Index++];
            }else {
                break;
            }
        }
        System.arraycopy(arr,0,nums1,0,m);
        return nums1;
    }

    private int[] mergeTwo(int[] arr1, int[] arr2) {
        int[] arr=new int[arr1.length+arr2.length];
        int arr1Index=0;
        int arr2Index=0;
        int i=0;
        while (arr1Index<arr1.length||arr2Index<arr2.length){
            if(arr1Index<arr1.length&&arr2Index<arr2.length&&arr1[arr1Index]!=0&&arr2[arr2Index]!=0){
                if(arr1[arr1Index]<arr2[arr2Index]){
                    arr[i++]=arr1[arr1Index++];
                }else{
                    arr[i++]=arr2[arr2Index++];
                }
            }else if(arr1Index<arr1.length&&arr1[arr1Index]!=0){
                arr[i++]=arr1[arr1Index++];
            }else if(arr2Index<arr2.length&&arr2[arr2Index]!=0){
                arr[i++]=arr2[arr2Index++];
            }else {
                break;
            }
        }
        return Arrays.copyOf(arr,Math.max(arr1.length,arr2.length));
    }
}
