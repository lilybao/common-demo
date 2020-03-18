package com.baoli.leetcode.day;

/**
 * @program: common-demo
 * @description: 字符串压缩
 * @author: li baojian
 * @create: 2020-03-16 23:05
 */
public class StrCompressDemo {
    public static void main(String[] args) {
//        String s1="aabcccccaaa";
        String s1="bbbac";
        String s2 =getCompressStr(s1);
        System.out.println(s2);
    }

    private static String getCompressStr(String s1) {
        String newStr="";
        int count=0;
        if(s1.length()>0){
            char a=s1.charAt(0);
            for (int i = 0; i <s1.length(); i++) {
                if(a==s1.charAt(i)){
                    count++;
                    if(i+1>=s1.length()){
                        newStr+=String.valueOf(a)+String.valueOf(count);
                        count=1;
                        a=s1.charAt(i);
                    }
                    continue;
                }
                newStr+=String.valueOf(a)+String.valueOf(count);
                count=1;
                a=s1.charAt(i);

            }
        }else {
            return s1;
        }
        return newStr.length()>=s1.length()?s1:newStr;
    }
}
