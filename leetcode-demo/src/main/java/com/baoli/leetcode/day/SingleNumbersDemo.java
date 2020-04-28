package com.baoli.leetcode.day;

import org.junit.Test;

/**
 * @program: common-demo
 * @description: 找出单次出现的两个数
 * @author: li baojian
 * @create: 2020-04-28 23:00
 */
public class SingleNumbersDemo {



    @Test
    public void test(){
        int[] nums={1,2,10,4,1,4,3,3};
        int[] ints = singleNumbers(nums);
        System.out.println(ints);
    }


    public int[] singleNumbers(int[] nums) {
        int ret=0;
        for(int n:nums){
            ret^=n;
        }
        int div=1;
        while ((ret&div)==0){//找到两个出现一次的数字 ，不相等的位数 ，根据这个位数来分组
            div<<=1;
        }
        int a=0;
        int b=0;
        for (int n:nums){
            if((div & n)>0){
                a^=n;
            }else {
                b^=n;
            }
        }
        return new int[]{a,b};

    }
}
