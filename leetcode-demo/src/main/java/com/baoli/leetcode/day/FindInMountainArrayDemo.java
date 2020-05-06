package com.baoli.leetcode.day;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: common-demo
 * @description: 查找山脉数组中的某个数字出现的最小下标
 * 1,3,5,7,9,8,5,1   z找出5出现的最小下标   2  二分超出峰值 ，在二分查找
 * @author: li baojian
 * @create: 2020-04-29 09:48
 */
public class FindInMountainArrayDemo {


    @Test
    public void test() {

    }


    private int findInMountainArray(MountainArray mountainArr, int target) {

        //找到峰值下标
        int length = mountainArr.length();
        int l = 0;
        int r = length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        //二分查找
        int peek = l;
        int index = binarySearch(mountainArr, target, 0, peek);
        if (index != -1) {
            return index;
        }
        return binarySearch1(mountainArr, target, peek, length - 1);
    }

    private int binarySearch1(MountainArray mountainArr, int target, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (target == mountainArr.get(mid)) {
                return mid;
            } else if (target < mountainArr.get(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearch(MountainArray mountainArr, int target, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (target == mountainArr.get(mid)) {
                return mid;
            } else if (target < mountainArr.get(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;

    }


}
