package com.baoli.leetcode.demo;/*
 * @项目名称: leetCode
 * @日期: 2019/5/24 0024 上午 9:48
 * @版权: 2019 河南中审科技有限公司 Inc. All rights reserved.
 * @开发公司或单位：河南中审科技有限公司研发中心
 */

import java.util.LinkedList;

/**
 * @ClassName: ConvertStoZ
 * @Description: TODO 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * @author: libaojian
 * @date: 2019/5/24 0024 上午 9:48
 * @version: V1.0
 */
public class ConvertStoZ {

    public static void main(String[] args) {
        String leetcodeishiring = convert("LEETCODEISHIRING", 4);
        System.out.println(leetcodeishiring);
    }
    //zxc v bnm a sdf g jhk numRows=3
    //zxcv b n masd f g jhk numRows=4
    public static String convert(String s, int numRows) {
        String str = "";
        int length=numRows*2-2;
        if(length<1){
            return s;
        }
        LinkedList<StringBuilder> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k <numRows ; k++) {
            list.add(new StringBuilder());
        }
        int i=0;
        while (i<s.length()){
            int a = i%length>=numRows?length-((i)%length):i%length;
            list.get(a).append(s.charAt(i++));
        }
        for (StringBuilder ss:
        list) {
            sb.append(ss);
        }
     return sb.toString();
    }
}
