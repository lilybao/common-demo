package com.baoli.leetcode.demo;/*
 * @项目名称: LeetCode
 * @日期: 2019/5/23 0023 上午 10:16
 * @版权: 2019 河南中审科技有限公司 Inc. All rights reserved.
 * @开发公司或单位：河南中审科技有限公司研发中心
 */

/**
 * @ClassName: TwoSum
 * @Description: TODO 两数之和
 * @author: libaojian
 * @date: 2019/5/23 0023 上午 10:16
 * @version: V1.0
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int target = 6;
        int[] sss = twoSum(a,target);
        System.out.println(sss[0]);
        System.out.println(sss[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] ss=new int[2];
        for(int i=0;i<nums.length;i++){
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j]==target){
                    ss[0]=i;
                    ss[1]=j;
                    break;
                }
            }
        }
        return  ss;
    }
}
