package com.baoli.leetcode.day;

import java.util.HashMap;

/**
 * @program: common-demo
 * @description: 构造最长的回文
 * @author: li baojian
 * @create: 2020-03-19 10:12
 */
public class LongestPalindromeDemo {
    public static void main(String[] args) {
//        String s="abccccdd";
        String s = "zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";
//        String str = "abc";
        System.out.println('a' + 0);
        System.out.println('A' + 0);
        System.out.println(7 & 1);
//        int l = getLongestPalindrome(str);
        int ss = getLongestPalindrome1(s);
        System.out.println(ss);
    }

    private static int getLongestPalindrome1(String s) {
        int[] count = new int[58];
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }
        int sum = 0;
        for (int i : count) {
            sum += i - (i & 1);
        }
        return s.length() > sum ? sum + 1 : sum;
    }

    //n个字符中，  奇数的个数不能大于1个
    private static int getLongestPalindrome(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            s = str.charAt(i) + "";
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        int sum = 0;
        boolean flag = false;
        for (String key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                sum = sum + map.get(key) - 1;
                flag = true;
            } else {
                sum += map.get(key);
            }
        }
        if (flag) {
            sum++;
        }
        return sum;
    }
}
