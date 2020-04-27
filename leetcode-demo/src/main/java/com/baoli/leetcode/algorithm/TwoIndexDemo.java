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
     * @param target 二分查找
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
            if (nums[0] < nums[mid]) {
                if (target >=nums[0] && target < nums[mid]) {
                    rightIndex = mid - 1;
                } else {
                    leftIndex = mid + 1;
                }
            } else {
                if (target >=nums[mid] && target <= nums[nums.length - 1]) {
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
}
