package com.baoli.leetcode.day;

/**
 * @program: common-demo
 * @description: 求两条线的交集
 * @author: li baojian
 * @create: 2020-04-12 21:39
 */
public class IntersectionDemo {
    public static void main(String[] args) {
        int [] start={0,0};
        int [] end={3,3};
        int[] start2={1,1};
        int[] end2={2,2};

        intersection(start,end,start2,end2);
    }

    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        //方程式1 0,0
        double rate1=(end1[1]-start1[1])/((end1[0]-start1[0])*1.0);
        double con1=start1[1]*1.0- start1[0]*rate1;
        //方程式2 2 ,-1
        double rate2=(end2[1]-start2[1])/((end2[0]-start2[0])*1.0);
        double con2=start2[1]*1.0- start2[0]*rate2;
        double a=(con2-con1)/(rate2-rate1);
        System.out.println(con1);


    return null;
    }
}
