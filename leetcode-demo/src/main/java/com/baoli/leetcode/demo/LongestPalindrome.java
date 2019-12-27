package com.baoli.leetcode.demo;/*
 * @项目名称: LeetCode
 * @日期: 2019/5/23 0023 上午 9:19
 * @版权: 2019 河南中审科技有限公司 Inc. All rights reserved.
 * @开发公司或单位：河南中审科技有限公司研发中心
 */

/**
 * @ClassName: LongestPalindrome
 * @Description: TODO
 * @author: libaojian
 * @date: 2019/5/23 0023 上午 9:19
 * @version: V1.0
 */
public class LongestPalindrome {
    public static  void main(String[] args){
        String ww = longestPalindrome("ababababsdfssdfd");
        System.out.println(ww);
    }

    /**
     * 最长回文查找  （2n-1）个中心
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s.length()<1){
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i=0;i<s.length();i++){
            int len1 = expendToCenter(s,i,i);
            int len2 = expendToCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len>(end-start)){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    private static int expendToCenter(String s, int left, int right) {
        int L = left ;
        int R =right;
        while ((L>=0)&&(R<s.length())&&(s.charAt(L)==s.charAt(R))){
            L--;
            R++;
        }
        return  R-L-1;

    }
}
