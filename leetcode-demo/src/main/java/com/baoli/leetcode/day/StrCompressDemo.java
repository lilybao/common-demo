package com.baoli.leetcode.day;

/**
 * @program: common-demo
 * @description: 字符串压缩
 * @author: li baojian
 * @create: 2020-03-16 23:05
 */
public class StrCompressDemo {
    public static void main(String[] args) {
        String s1 = "aabcccccaaa";
//        String s1=" ";
//        String s1 = "bbbac";
//        String s2 =getCompressStr(s1);
        String s3 = getCompressStr2(s1);
        System.out.println(s3);
    }

    private static String getCompressStr2(String s1) {
        String newStr = "";
        int count = 0;
        if (s1.length() == 0) {
            return s1;
        }
        s1 += " ";
        char next = ' ';
        for (int i = 0; i < s1.length(); i++) {
            if (next == s1.charAt(i)) {
                count++;
                continue;
            }
            if (next != ' ') {
                newStr += next + "" + count;
            }
            next = s1.charAt(i);
            count = 1;
        }
        s1 = s1.substring(0, s1.length() - 1);
        return newStr.length() >= s1.length() ? s1 : newStr;
    }

    private static String getCompressStr(String s1) {
        String newStr = "";
        int count = 0;
        if (s1.length() > 0) {
            char a = s1.charAt(0);
            for (int i = 0; i < s1.length(); i++) {
                if (a == s1.charAt(i)) {
                    count++;
                    if (i + 1 >= s1.length()) {
                        newStr += String.valueOf(a) + String.valueOf(count);
                        count = 1;
                        a = s1.charAt(i);
                    }
                    continue;
                }
                newStr += String.valueOf(a) + String.valueOf(count);
                count = 1;
                a = s1.charAt(i);

            }
        } else {
            return s1;
        }
        return newStr.length() >= s1.length() ? s1 : newStr;
    }
}
