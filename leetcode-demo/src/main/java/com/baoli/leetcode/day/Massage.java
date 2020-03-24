package com.baoli.leetcode.day;

import java.util.Arrays;

/**
 * @program: common-demo
 * @description: 按摩师
 * @author: li baojian
 * @create: 2020-03-24 22:10
 */
public class Massage {
    public static void main(String[] args) {
//            int[]nums={1,2,3,1};
            int[]nums={1};
        int massage = massage(nums);
        System.out.println(massage);
    }

    public static int massage(int[] nums) {
        if(nums.length==0){
            return 0;
        }
            int dps0=0;
            int dps1=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tps0=Math.max(dps0,dps1);
            int tps1=dps0+nums[i];
            dps0=tps0;
            dps1=tps1;
        }
        return Math.max(dps0,dps1);
    }
}
