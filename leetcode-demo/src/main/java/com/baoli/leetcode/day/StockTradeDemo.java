package com.baoli.leetcode.day;

/**
 * @program: common-demo
 * @description: 股票交易
 * @author: li baojian
 * @create: 2020-03-09 22:02
 */
public class StockTradeDemo {
    public static void main(String[] args) {
        int[] prices ={7,1,5,3,6,4};
//        int[] prices = {7, 6, 4, 3, 1};
//        int max = 0;
//        //时间复杂度 m（1+m）/2
//        for (int i = prices.length - 1; i >= 0; i--) {
//            for (int j = i - 1; j >= 0; j--) {
//                int m = prices[i] - prices[j];
//                if (m > max) {
//                    max = m;
//                }
//            }
//        }
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(max);
        int i = getMaxProfile(prices);
        System.out.println(i);
    }

    private static int getMaxProfile(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfile = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice=Math.min(prices[i],minPrice);
            maxProfile=Math.max(maxProfile,prices[i]-minPrice);
//            if (prices[i] < minPrice) {
//                minPrice = prices[i];
//            }else if(prices[i]-minPrice>maxProfile){
//                maxProfile=prices[i]-minPrice;
//            }
        }
        return maxProfile;
    }


}
