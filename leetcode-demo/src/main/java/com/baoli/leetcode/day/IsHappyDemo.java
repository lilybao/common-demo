package com.baoli.leetcode.day;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @program: common-demo
 * @description: 判断是否是快乐数
 * @author: li baojian
 * @create: 2020-04-30 11:44
 */
public class IsHappyDemo {


    @Test
    public void test() {
        boolean happy = isHappy(101);
        System.out.println(happy);
    }
    //时间复杂度  O()
    public boolean isHappy(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int k=n;
        while (k!=1){
            if(list.contains(k)){
                return false;
            }
            list.add(k);
            int[] arr = getArr(k);
            k=0;
            for (int i = 0; i < arr.length; i++) {
                k+=(arr[i]*arr[i]);
            }
        }
        return true ;
    }

    private int[] getArr(int n) {
        String s = String.valueOf(n);
        int length = s.length();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i]=Integer.valueOf(s.charAt(i))-48;
        }
        return arr;
    }
}
