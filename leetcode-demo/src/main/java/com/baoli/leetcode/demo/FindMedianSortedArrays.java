package com.baoli.leetcode.demo;/*
 * @项目名称: LeetCode
 * @日期: 2019/5/23 0023 上午 9:23
 * @版权: 2019 河南中审科技有限公司 Inc. All rights reserved.
 * @开发公司或单位：河南中审科技有限公司研发中心
 */

import java.util.ArrayList;

/**
 * @ClassName: FindMedianSortedArrays
 * @Description: TODO
 * @author: libaojian
 * @date: 2019/5/23 0023 上午 9:23
 * @version: V1.0
 */
public class FindMedianSortedArrays {

    public static  void main(String[] args){
        int[] a ={1,1};
        int[] b ={1,2};
        double midNum = findMedianSortedArrays(a, b);
        System.out.println(midNum);

    }

    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
        int a = nums1.length;
        int b =nums2.length;
        double result = 0.0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0,j=0;(i<a||j<b);){
            if((i<a)&&(j>=b||(nums1[i]<=nums2[j]))){
                list.add(nums1[i]);
                i++;
            }
            if((j<b)&&((i>=a)||(nums2[j]<nums1[i]))){
                list.add(nums2[j]);
                j++;
            }
        }
        if((list.size())%2==0){
            result=  (list.get(list.size()/2)+list.get(list.size()/2-1))/2.0;
        }else {
            result= list.get((list.size()+1)/2-1)*1.0;
        }
        return  result;
    }
}
