package com.baoli.leetcode.demo;/*
 * @项目名称: LeetCode
 * @日期: 2019/5/23 0023 上午 10:06
 * @版权: 2019 河南中审科技有限公司 Inc. All rights reserved.
 * @开发公司或单位：河南中审科技有限公司研发中心
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName: LengthOfLongestSubstring
 * @Description: TODO
 * @author: libaojian
 * @date: 2019/5/23 0023 上午 10:06
 * @version: V1.0
 */
public class LengthOfLongestSubstring {
    //无重复字符的最长子字符串
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("gsdfgsfdgsf");
        int length1 = lengthOfLongestSubstring1("gsdfgsfdgsf");
        System.out.println(length);
    }

    private static int lengthOfLongestSubstring1(String s) {
        if(s.length()==0){
            return 0;
        }else if(s.length()==1){
            return 1;
        }
        //存放字符串
        int length =0;
        int begin = 0;
        int end = 1;
        String sub = "";
        String nextSub = "";
        while(end <s.length()){
            sub = s.substring(begin, end);
            nextSub = s.substring(end, end+1);
            if(sub.contains(nextSub)){
                if(sub.length()>length){
                    length=sub.length();
                }
                int i = sub.indexOf(nextSub);
                begin=begin+i+1;
                end =end+1;
            }else {
                end = end+1;
                if(end==s.length()&&sub.length()+1>length){
                    return sub.length()+1;
                }
            }

        }
        return length;
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }else if(s.length()==1){
            return 1;
        }
        //存放字符串
        ArrayList<Integer> list = new ArrayList<>();
        int begin = 0;
        int end = 1;
        String sub = "";
        while(end <s.length()){
            sub = s.substring(begin, end);
            String nextSub = s.substring(end, end+1);
            if(sub.contains(nextSub)){
                list.add(sub.length());
                int i = sub.indexOf(nextSub);
                begin=begin+i+1;
                end =end+1;
            }else {
                end = end+1;
                if(end==s.length()){
                    list.add(sub.length()+1);
                }
            }

        }
        if(list.size()==0){
            return s.length();
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }
}
