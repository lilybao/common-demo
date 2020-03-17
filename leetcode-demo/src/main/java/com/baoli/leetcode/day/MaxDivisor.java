package com.baoli.leetcode.day;

/**
 * @program: common-demo
 * @description: 求最大公约数
 * @author: li baojian
 * @create: 2020-03-12 20:34
 */
public class MaxDivisor {
    public static void main(String[] args) {
        String str1 = "abcabc";
        String str2 = "abca";

        String s = "";
        s = getstr(s, str1, str2);
        System.out.println(s);

    }

    private static String getstr(String s, String str1, String str2) {
        if (str1.contains(str2) || str2.contains(str1)) {
            int min = Math.min(str1.length(), str2.length());
            String ss = str1.length() == min ? str1 : str2;
            for (int i = min; i > 0; i--) {
                if (str1.length() % i == 0 && str2.length() % i == 0) {
                    s = ss.substring(0, i);
                    if (str1.replace(s, "").equals("") && str2.replace(s, "").equals("")) {
                        return s;
                    }
                }
            }
            return "";
        } else {
            return "";
        }
    }
}
