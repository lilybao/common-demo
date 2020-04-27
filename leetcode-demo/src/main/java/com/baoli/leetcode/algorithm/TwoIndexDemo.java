package com.baoli.leetcode.algorithm;

import org.junit.Test;

/**
 * @program: common-demo
 * @description: 双指针算法
 * @author: li baojian
 * @create: 2020-04-27 15:15
 */
public class TwoIndexDemo {
    /**
     * 有序数组中的两个数加起来 和为target
     */
    @Test
    public void sumTwoSequence() {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] ints = twoSum(nums, target);
        System.out.println(ints);

    }

    /**
     * 查找根据某个点旋转后的有序数组 是否包含某个元素
     */
    @Test
    public void searchIndex() {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {3,1};
        int target = 1;
        int search = search1(nums, target);
        System.out.println(search);

    }

    /**
     * @param nums
     * @param target 二分查找   时间复杂度  O（log n）  空间复杂度的 O（1）
     * @return
     */
    public int search1(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int mid;
        while (leftIndex <= rightIndex) {
            mid = (leftIndex + rightIndex) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (target >=nums[0] && target < nums[mid]) {
                    rightIndex = mid - 1;
                } else {
                    leftIndex = mid + 1;
                }
            } else {
                if (target >nums[mid] && target <= nums[nums.length - 1]) {
                    leftIndex = mid + 1;
                } else {
                    rightIndex = mid - 1;
                }
            }
        }
        return -1;

    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int index;
        while (leftIndex <= rightIndex) {
            if (nums[leftIndex] == target) {
                return leftIndex;
            } else if (nums[rightIndex] == target) {
                return rightIndex;
            } else if (nums[leftIndex] > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return -1;

    }

    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            if (numbers[leftIndex] + numbers[rightIndex] == target) {
                arr[0] = leftIndex + 1;
                arr[1] = rightIndex + 1;
                break;
            } else if (numbers[leftIndex] + numbers[rightIndex] > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return arr;
    }

    /**
     * 二分查找  数组 中是否包含某个元素
     */
    @Test
    public void test2(){
        int[] nums={1,23,54,43,67,86,55};
        fastSort(nums,0,nums.length-1);
        int target=33;
       int index= twoSplitSearch(nums,target);
        System.out.println(index);
        System.out.println(nums);
    }

    /**
     * 二分查找  双指针
     * @param nums
     * @param target
     * @return
     */
    private int twoSplitSearch(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid;
        while (left<=right){
             mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[left]<=target&&target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    private void fastSort(int[] nums, int left, int right) {
       if(left<right){
          int mid= particition(nums,left,right);
          fastSort(nums,left,mid-1);
          fastSort(nums,mid+1,right);
       }
    }

    private int particition(int[] nums, int left, int right) {
        int i=left;
        int j=right+1;
        int mid=nums[left];
        while (true){
            while (--j>i&&nums[j]>mid);
            while (++i<j&&nums[i]<mid);
            if(i>=j){
                break;
            }
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        nums[left]=nums[j];
        nums[j]=mid;
        return j;
    }
}
